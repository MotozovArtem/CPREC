package io.rienel.cw4.test.export;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import io.rienel.export.CsvExportService;
import io.rienel.export.ExportService;
import io.rienel.model.CurrencyExchange;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CsvExportTest {
	private String expectedCsv = """
			id,value,nominal,currency_name,currency_code,date
			1,100.0,1,TEST,TST,2022-10-22
			""";

	private List<CurrencyExchange> testCurrencyExchangeList = List.of(
			new CurrencyExchange(1,
					100.0,
					1,
					"TEST",
					"TST",
					LocalDate.of(2022, Month.OCTOBER, 22))
	);

	@Test
	public void testExportToCsv() {
		ExportService exportService = new CsvExportService();
		String exportedValue = exportService.export(testCurrencyExchangeList);
		Assertions.assertEquals(expectedCsv, exportedValue);
	}
}
