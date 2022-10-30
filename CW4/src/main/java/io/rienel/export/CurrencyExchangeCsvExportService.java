package io.rienel.export;

import java.io.IOException;
import java.io.StringWriter;
import java.util.List;
import java.util.Objects;

import io.rienel.model.CurrencyExchange;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.jetbrains.annotations.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CurrencyExchangeCsvExportService implements ExportService<CurrencyExchange> {

	private static final Logger log = LoggerFactory.getLogger(CurrencyExchangeCsvExportService.class);

	private static final String COLUMN_ID = "id";
	private static final String COLUMN_VALUE = "value";
	private static final String COLUMN_NOMINAL = "nominal";
	private static final String COLUMN_CURRENCY_NAME = "currency_name";
	private static final String COLUMN_CURRENCY_CODE = "currency_code";
	private static final String COLUMN_DATE = "date";

	private final @NotNull CSVFormat csvFormat;

	public CurrencyExchangeCsvExportService(@NotNull CSVFormat csvFormat) {
		Objects.requireNonNull(csvFormat);

		this.csvFormat = csvFormat;
	}

	public CurrencyExchangeCsvExportService() {
		this(CSVFormat.DEFAULT);
	}

	private final List<String> header = List.of(COLUMN_ID, COLUMN_VALUE, COLUMN_NOMINAL, COLUMN_CURRENCY_NAME, COLUMN_CURRENCY_CODE, COLUMN_DATE);

	@Override
	public @NotNull String export(@NotNull List<CurrencyExchange> currencyExchange) {
		Objects.requireNonNull(currencyExchange);

		StringWriter writer = new StringWriter();
		try (CSVPrinter printer = new CSVPrinter(writer, CSVFormat.DEFAULT)) {
			printer.printRecord(header);
			for (CurrencyExchange cur : currencyExchange) {
				printer.printRecord(
						cur.getId(),
						cur.getValue(),
						cur.getNominal(),
						cur.getCurrencyName(),
						cur.getCurrencyCode(),
						cur.getDate()
				);
			}
		} catch (IOException e) {
			log.error("Error while exporting data to CSV file", e);
		}
		return writer.toString().replaceAll("\\r\\n?", "\n");
	}
}
