package io.rienel.converter;

import java.time.LocalDate;

import io.rienel.dto.Valute;
import io.rienel.model.CurrencyExchange;

public class CurrencyExchangeValuteConverter implements Converter<CurrencyExchange, Valute> {

	@Override
	public CurrencyExchange toDomain(Valute valute) {
		return new CurrencyExchange(-1,
				valute.getValue(),
				valute.getNominal(),
				valute.getName(),
				valute.getCharCode(),
				LocalDate.EPOCH);
	}

	@Override
	public Valute toDto(CurrencyExchange currencyExchange) {
		return new Valute(
				"",
				0,
				currencyExchange.getCurrencyCode(),
				currencyExchange.getNominal(),
				currencyExchange.getCurrencyName(),
				currencyExchange.getValue()
		);
	}
}
