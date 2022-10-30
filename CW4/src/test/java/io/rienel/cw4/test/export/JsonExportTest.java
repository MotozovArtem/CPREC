package io.rienel.cw4.test.export;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import io.rienel.export.ExportService;
import io.rienel.export.CurrencyExchangeJsonExportService;
import io.rienel.model.CurrencyExchange;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class JsonExportTest {
	private String expectedJson = """
			[{"id":1,"value":100.0,"nominal":1,"currencyName":"TEST","currencyCode":"TST","date":"2022-10-22"}]""";

	private List<CurrencyExchange> testCurrencyExchange = List.of(new CurrencyExchange(
			1,
			100.0,
			1,
			"TEST",
			"TST",
			LocalDate.of(2022, Month.OCTOBER, 22)
	));

	@Test
	public void testExportToJson() {
		ExportService<CurrencyExchange> exportService = new CurrencyExchangeJsonExportService(false);
		String exportedData = exportService.export(testCurrencyExchange);
		Assertions.assertEquals(expectedJson, exportedData);
	}
}
