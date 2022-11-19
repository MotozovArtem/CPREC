package io.rienel.test;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import io.rienel.Valute;
import io.rienel.ValuteLoader;
import org.junit.Assert;
import org.junit.Test;

/**
 * TODO ArMotozov
 *
 * @since 11/19/2022
 */
public class CsvTest {

	private ValuteLoader valuteLoader = new ValuteLoader();

	@Test
	public void testReadValuteFromCsvFile() throws ParseException, IOException {
		List<Valute> valuteList = valuteLoader.loadValute("src/test/resources/currency_test.csv");
		Assert.assertNotNull(valuteList);
		Assert.assertEquals(1, valuteList.size());
		for (int i = 0; i < valuteList.size(); i++) {
			Valute valute = valuteList.get(i);
			Assert.assertNotNull(valute.getId());
			Assert.assertEquals("1", valute.getId());
			Assert.assertNotNull(valute.getCurrencyCode());
			Assert.assertEquals("AUD", valute.getCurrencyCode());
			Assert.assertNotNull(valute.getCurrencyName());
			Assert.assertEquals("Австралийский доллар", valute.getCurrencyName());
			Assert.assertNotNull(valute.getDate());
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
			Date date = formatter.parse("2022-11-19");
			Assert.assertEquals(date, valute.getDate());
		}
	}

	@Test
	public void testReadValuteFromEmptyCsvFile() throws IOException {
		List<Valute> valutes = valuteLoader.loadValute("src/test/resources/currency_empty.csv");
		Assert.assertNotNull(valutes);
		Assert.assertEquals(0, valutes.size());
	}

	@Test
	public void testReadValuteFromNotExistingFile() {
		Assert.assertThrows(FileNotFoundException.class, () -> valuteLoader.loadValute("asdfasdf"));
	}
}



















