package io.rienel.controller;

import java.time.LocalDate;
import java.util.List;

import io.rienel.model.CurrencyExchange;

public interface CurrencyExchangeController {
	List<CurrencyExchange> updateCurrency(LocalDate currencyExchangeDate);

	List<CurrencyExchange> getAllCurrencyExchanges();

}
