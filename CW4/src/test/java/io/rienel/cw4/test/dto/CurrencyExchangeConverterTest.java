package io.rienel.cw4.test.dto;

import java.time.LocalDate;

import io.rienel.converter.Converter;
import io.rienel.converter.CurrencyExchangeValuteConverter;
import io.rienel.dto.Valute;
import io.rienel.model.CurrencyExchange;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class CurrencyExchangeConverterTest {

	private Converter<CurrencyExchange, Valute> currencyExchangeValuteConverter = new CurrencyExchangeValuteConverter();

	private final LocalDate date = LocalDate.now();

	private CurrencyExchange currencyExchange = new CurrencyExchange(
			-1,
			100.0,
			1,
			"Test",
			"TST",
			date
	);

	private Valute valute = new Valute(
			"R01",
			36,
			"TST",
			1,
			"Test",
			100.0
	);

	@Test
	public void testDomainToDtoConverter() {
		Valute convertedValute = currencyExchangeValuteConverter.toDto(currencyExchange);

		assertNotNull(convertedValute);
		assertEquals("", convertedValute.getId());
		assertEquals(0, convertedValute.getNumCode());
		assertEquals(valute.getCharCode(), convertedValute.getCharCode());
		assertEquals(valute.getNominal(), convertedValute.getNominal());
		assertEquals(valute.getValue(), convertedValute.getValue());
		assertEquals(valute.getName(), convertedValute.getName());
	}

	@Test
	public void testDtoToDomainConverter() {
		CurrencyExchange convertedDomain = currencyExchangeValuteConverter.toDomain(valute);

		assertNotNull(convertedDomain);
		assertEquals(currencyExchange.getId(),
				convertedDomain.getId());
		assertEquals(currencyExchange.getNominal(),
				convertedDomain.getNominal());
		assertEquals(currencyExchange.getCurrencyCode(),
				convertedDomain.getCurrencyCode());
		assertEquals(currencyExchange.getValue(),
				convertedDomain.getValue());
		assertEquals(currencyExchange.getCurrencyName(),
				convertedDomain.getCurrencyName());
		assertEquals(LocalDate.EPOCH,
				convertedDomain.getDate());
	}
}
