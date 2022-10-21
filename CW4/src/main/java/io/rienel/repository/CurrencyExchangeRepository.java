package io.rienel.repository;

import java.util.List;

import io.rienel.model.CurrencyExchange;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public interface CurrencyExchangeRepository {
	@Nullable CurrencyExchange findById(@NotNull Integer id);

	@NotNull List<CurrencyExchange> findAll();

	@NotNull List<CurrencyExchange> findAllByCode(@NotNull String currencyCode);

	int delete(@NotNull Integer id);

	int deleteAll();

	int insert(@NotNull CurrencyExchange currency);

	int update(@NotNull CurrencyExchange currency);
}
