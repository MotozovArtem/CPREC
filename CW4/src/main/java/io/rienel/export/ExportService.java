package io.rienel.export;

import java.util.List;

import org.jetbrains.annotations.NotNull;

public interface ExportService<T> {
	@NotNull String export(@NotNull List<T> currencyExchange);
}
