package io.rienel.repository.impl;

import java.util.List;

import io.rienel.model.CurrencyExchange;
import io.rienel.repository.CurrencyExchangeRepository;

public class CurrencyExchangeRepositorySqliteImpl implements CurrencyExchangeRepository {
	@Override
	public CurrencyExchange findById(Integer id) {
		return null;
	}

	@Override
	public List<CurrencyExchange> findAll() {
		return null;
	}

	@Override
	public List<CurrencyExchange> findAllByCode(String currencyCode) {
		return null;
	}

	@Override
	public int delete(Integer id) {
		return 0;
	}

	@Override
	public int insert(CurrencyExchange currency) {
		return 0;
	}

	@Override
	public int update(CurrencyExchange currency) {
		return 0;
	}
}
