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

public class CsvExportService implements ExportService {

	private static final Logger log = LoggerFactory.getLogger(CsvExportService.class);

	public static final String COLUMN_ID = "id";
	public static final String COLUMN_VALUE = "value";
	public static final String COLUMN_NOMINAL = "nominal";
	public static final String COLUMN_CURRENCY_NAME = "currency_name";
	public static final String COLUMN_CURRENCY_CODE = "currency_code";
	public static final String COLUMN_DATE = "date";

	private @NotNull CSVFormat csvFormat;

	public CsvExportService(@NotNull CSVFormat csvFormat) {
		Objects.requireNonNull(csvFormat);

		this.csvFormat = csvFormat;
	}

	public CsvExportService() {
		this.csvFormat = CSVFormat.DEFAULT;
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
