package io.rienel.repository;

import java.util.List;

import io.rienel.model.CurrencyExchange;

public interface CurrencyExchangeRepository {
	CurrencyExchange findById(Integer id);

	List<CurrencyExchange> findAll();

	List<CurrencyExchange> findAllByCode(String currencyCode);

	int delete(Integer id);

	int insert(CurrencyExchange currency);

	int update(CurrencyExchange currency);
}
