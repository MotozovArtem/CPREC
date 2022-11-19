package io.rienel.test;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Locale;

import io.rienel.Valute;
import io.rienel.ValuteLoader;
import org.junit.Assert;
import org.junit.Test;
import org.junit.function.ThrowingRunnable;

/**
 * TODO ArMotozov
 *
 * @since 11/19/2022
 */
public class ValuteLoaderTest {

	private ValuteLoader valuteLoader = new ValuteLoader();

	@Test
	public void testLoadSingleValuteFromCsv() throws ParseException, IOException {
		List<Valute> valuteList = valuteLoader.loadValute("src/test/resources/currency_single_test.csv");
		Assert.assertNotNull(valuteList);
		Assert.assertEquals(1, valuteList.size());
		Valute valute = valuteList.get(0);
		Assert.assertNotNull(valute.getId());
		Assert.assertEquals("1", valute.getId());
		Assert.assertEquals(40.4748, valute.getValue(), 0.0001);
		Assert.assertEquals(1, valute.getNominal());
		Assert.assertNotNull(valute.getCurrencyName());
		Assert.assertEquals("Австралийский доллар",valute.getCurrencyName());
		Assert.assertNotNull(valute.getCurrencyCode());
		Assert.assertEquals("AUD",valute.getCurrencyCode());
		Assert.assertNotNull(valute.getDate());
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
		Assert.assertEquals(formatter.parse("2022-11-19"), valute.getDate());
	}

	@Test
	public void testLoadFewValuteFromCsv() throws IOException {
		List<Valute> valuteList = valuteLoader.loadValute("src/test/resources/currency_few_test.csv");
		Assert.assertNotNull(valuteList);
		Assert.assertEquals(10, valuteList.size());
	}

	@Test
	public void testLoadDataFromNotExistingFile() {
		Assert.assertThrows(FileNotFoundException.class, () -> {
			valuteLoader.loadValute("asdfasdf.csv");
		});
	}
}
