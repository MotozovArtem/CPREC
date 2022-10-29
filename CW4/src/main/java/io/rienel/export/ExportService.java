package io.rienel.export;

import java.util.List;

import io.rienel.model.CurrencyExchange;
import org.jetbrains.annotations.NotNull;

public interface ExportService {
	@NotNull String export(@NotNull List<CurrencyExchange> currencyExchange);
}
