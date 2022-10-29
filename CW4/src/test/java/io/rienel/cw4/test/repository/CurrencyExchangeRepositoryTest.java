package io.rienel.cw4.test.repository;

import java.time.LocalDate;

import io.rienel.database.Database;
import io.rienel.model.CurrencyExchange;
import io.rienel.repository.CurrencyExchangeRepository;
import io.rienel.repository.impl.CurrencyExchangeRepositorySqliteImpl;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class CurrencyExchangeRepositoryTest {
	private final CurrencyExchangeRepository currencyExchangeRepository = CurrencyExchangeRepositorySqliteImpl.getInstance();

	private final CurrencyExchange currencyExchange1 = new CurrencyExchange(
			1,
			100.0,
			1,
			"TEST",
			"TST",
			LocalDate.now()
	);
	private final CurrencyExchange currencyExchange2 = new CurrencyExchange(
			2,
			200.0,
			2,
			"TEST2",
			"TS2",
			LocalDate.now()
	);

	@BeforeEach
	public void initDb() {
		CurrencyExchangeRepositorySqliteImpl.getInstance().insert(currencyExchange1);
		CurrencyExchangeRepositorySqliteImpl.getInstance().insert(currencyExchange2);
	}

	@AfterEach
	public void clearDb() {
		CurrencyExchangeRepositorySqliteImpl.getInstance().deleteAll();
		Database.getInstance().closeConnection();
	}

	@Test
	public void testCurrencyExchangeInsert() {
		CurrencyExchange currencyExchange3 = new CurrencyExchange(
				3,
				300.0,
				3,
				"TEST3",
				"TS3",
				LocalDate.now()
		);
		int insert = currencyExchangeRepository.insert(currencyExchange3);
		assertEquals(1, insert);
		CurrencyExchange savedValue = currencyExchangeRepository.findById(3);
		assertNotNull(savedValue);
		assertEquals(currencyExchange3.getId(), savedValue.getId());
		assertEquals(currencyExchange3.getValue(), savedValue.getValue(), 0.001);
		assertEquals(currencyExchange3.getNominal(), savedValue.getNominal());
		assertEquals(currencyExchange3.getCurrencyName(), savedValue.getCurrencyName());
		assertEquals(currencyExchange3.getCurrencyCode(), savedValue.getCurrencyCode());
		assertEquals(currencyExchange3.getDate(), savedValue.getDate());
	}

	@Test
	public void testCurrencyExchangeUpdate() {
		CurrencyExchange newCurrencyExchange2 = new CurrencyExchange(
				2,
				400.0,
				1000,
				"TEST22",
				"2TS",
				LocalDate.now()
		);
		int update = currencyExchangeRepository.update(newCurrencyExchange2);
		assertEquals(1, update);
		CurrencyExchange updatedValue = currencyExchangeRepository.findById(2);
		assertNotNull(updatedValue);
		assertEquals(newCurrencyExchange2.getId(), updatedValue.getId());
		assertEquals(newCurrencyExchange2.getValue(), updatedValue.getValue(), 0.001);
		assertEquals(newCurrencyExchange2.getNominal(), updatedValue.getNominal());
		assertEquals(newCurrencyExchange2.getCurrencyName(), updatedValue.getCurrencyName());
		assertEquals(newCurrencyExchange2.getCurrencyCode(), updatedValue.getCurrencyCode());
		assertEquals(newCurrencyExchange2.getDate(), updatedValue.getDate());
	}
}
