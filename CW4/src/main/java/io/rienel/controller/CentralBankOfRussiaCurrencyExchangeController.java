package io.rienel.controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import io.rienel.converter.Converter;
import io.rienel.converter.CurrencyExchangeValuteConverter;
import io.rienel.dto.ValCurs;
import io.rienel.dto.Valute;
import io.rienel.http.CentralBankOfRussia;
import io.rienel.http.CentralBankOfRussianService;
import io.rienel.model.CurrencyExchange;
import io.rienel.repository.CurrencyExchangeRepository;
import io.rienel.repository.impl.CurrencyExchangeRepositorySqliteImpl;
import org.jetbrains.annotations.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CentralBankOfRussiaCurrencyExchangeController implements CurrencyExchangeController {

	private static final Logger log = LoggerFactory.getLogger(CentralBankOfRussiaCurrencyExchangeController.class);

	private static CurrencyExchangeController instance;

	private final CurrencyExchangeRepository currencyExchangeRepository;

	private final Converter<CurrencyExchange, Valute> currencyExchangeValuteConverter;

	private CentralBankOfRussiaCurrencyExchangeController() {
		currencyExchangeRepository = CurrencyExchangeRepositorySqliteImpl.getInstance();
		currencyExchangeValuteConverter = new CurrencyExchangeValuteConverter();
	}

	public static CurrencyExchangeController getInstance() {
		if (instance == null) {
			log.debug("Initializing...");
			instance = new CentralBankOfRussiaCurrencyExchangeController();
			log.debug("Initialized...");
		}
		return instance;
	}

	@NotNull
	@Override
	public List<CurrencyExchange> updateCurrency(@NotNull LocalDate currencyExchangeDate) {
		Objects.requireNonNull(currencyExchangeDate);

		final CentralBankOfRussianService centralBankOfRussianService = CentralBankOfRussia.newClient(CentralBankOfRussia.CBR_URL);
		final String centralBankOfRussiaDateFormatPattern = "dd/MM/yyyy";
		final String requestedCurrencyExchangeOfDate = DateTimeFormatter
				.ofPattern(centralBankOfRussiaDateFormatPattern)
				.format(currencyExchangeDate);
		final ValCurs valCursList = centralBankOfRussianService.getExchange(requestedCurrencyExchangeOfDate);
		final Date currencyExchangeResponseDate = valCursList.getDate();
		final List<CurrencyExchange> convertedValute = new ArrayList<>();
		for (Valute valute : valCursList.getValuteList()) {
			final CurrencyExchange currencyExchange = currencyExchangeValuteConverter.toDomain(valute);
			currencyExchange.setDate(LocalDate.from(currencyExchangeResponseDate.toInstant()));
			convertedValute.add(currencyExchange);
		}
		if (currencyExchangeRepository.existsWithDate(currencyExchangeDate)) {
			List<CurrencyExchange> allByDate = currencyExchangeRepository.findAllByDate(currencyExchangeDate);
			for (CurrencyExchange currencyExchangeInDatabase : allByDate) {
				final CurrencyExchange receivedExchange = convertedValute.stream()
						.filter(cur -> cur.getCurrencyCode().equals(currencyExchangeInDatabase.getCurrencyCode()))
						.findFirst()
						.orElse(null);
				if (receivedExchange == null) {
					log.warn("There is no received currency exchange (code = {}) in database with date {}",
							currencyExchangeInDatabase.getCurrencyCode(), currencyExchangeInDatabase.getDate());
					continue;
				}
				currencyExchangeInDatabase.setValue(receivedExchange.getValue());
				currencyExchangeRepository.update(currencyExchangeInDatabase);
			}

		} else {
			for (CurrencyExchange currencyExchange : convertedValute) {
				currencyExchangeRepository.insert(currencyExchange);
			}
		}
		return currencyExchangeRepository.findAllByDate(currencyExchangeDate);
	}

	@Override
	public List<CurrencyExchange> getAllCurrencyExchanges() {
		return currencyExchangeRepository.findAll();
	}
}
