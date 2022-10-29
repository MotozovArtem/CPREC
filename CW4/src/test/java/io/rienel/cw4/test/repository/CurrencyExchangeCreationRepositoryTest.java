package io.rienel.cw4.test.repository;

import java.time.LocalDate;

import io.rienel.database.Database;
import io.rienel.model.CurrencyExchange;
import io.rienel.repository.CurrencyExchangeRepository;
import io.rienel.repository.impl.CurrencyExchangeRepositorySqliteImpl;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CurrencyExchangeCreationRepositoryTest {

	CurrencyExchangeRepository currencyExchangeRepository = CurrencyExchangeRepositorySqliteImpl.getInstance();

	public final CurrencyExchange currencyExchange = new CurrencyExchange(
			-1,
			100.0,
			1,
			"TEST",
			"TST",
			LocalDate.now()
	);

	@AfterAll
	public static void closeDb() {
		CurrencyExchangeRepositorySqliteImpl.getInstance().deleteAll();
		Database.getInstance().closeConnection();
	}

	@Test
	public void insertTest() {
		int insert = currencyExchangeRepository.insert(currencyExchange);
		assertEquals(1, insert);
	}

	@Test
	public void autoincrementTest() {
		int insertedRows = currencyExchangeRepository.insert(currencyExchange);
		assertEquals(1, insertedRows);
		insertedRows = currencyExchangeRepository.insert(currencyExchange);
		assertEquals(1, insertedRows);
	}
}
