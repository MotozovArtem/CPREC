package io.rienel.export;

import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.util.StdDateFormat;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import io.rienel.model.CurrencyExchange;
import org.jetbrains.annotations.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CurrencyExchangeJsonExportService implements ExportService<CurrencyExchange> {

	private static final Logger log = LoggerFactory.getLogger(CurrencyExchangeJsonExportService.class);

	private final ObjectMapper objectMapper;
	private final boolean usePrettier;

	public CurrencyExchangeJsonExportService(boolean usePrettier) {
		this.objectMapper = new ObjectMapper()
				.registerModule(new JavaTimeModule())
				.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS)
				.setDateFormat(new StdDateFormat().withColonInTimeZone(false));
		this.usePrettier = usePrettier;
	}

	@Override
	public @NotNull String export(@NotNull List<CurrencyExchange> currencyExchange) {
		Objects.requireNonNull(currencyExchange);

		if (usePrettier) {
			try {
				return objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(currencyExchange);
			} catch (JsonProcessingException e) {
				log.error("Cannot export object to JSON", e);
				throw new RuntimeException(e);
			}
		} else {
			try {
				return objectMapper.writeValueAsString(currencyExchange);
			} catch (JsonProcessingException e) {
				log.error("Cannot export object to JSON", e);
				throw new RuntimeException(e);
			}
		}
	}
}
