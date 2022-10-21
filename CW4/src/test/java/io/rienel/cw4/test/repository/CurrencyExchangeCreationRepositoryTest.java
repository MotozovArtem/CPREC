package io.rienel.cw4.test.repository;

import java.time.LocalDate;

import io.rienel.database.Database;
import io.rienel.model.CurrencyExchange;
import io.rienel.repository.CurrencyExchangeRepository;
import io.rienel.repository.impl.CurrencyExchangeRepositorySqliteImpl;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;

public class CurrencyExchangeCreationRepositoryTest {

	CurrencyExchangeRepository currencyExchangeRepository = new CurrencyExchangeRepositorySqliteImpl();

	public final CurrencyExchange currencyExchange = new CurrencyExchange(
			1,
			100.0,
			1,
			"TEST",
			"TST",
			LocalDate.now()
	);

	@AfterAll
	public static void closeDb() {
		new CurrencyExchangeRepositorySqliteImpl().deleteAll();
		Database.getInstance().closeConnection();
	}

	@Test
	public void insertTest() {
		currencyExchangeRepository.insert(currencyExchange);
	}
}
