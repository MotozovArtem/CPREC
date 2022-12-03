package io.rienel.test;

import java.io.IOException;
import java.util.List;

import io.rienel.SortService;
import io.rienel.Valute;
import io.rienel.ValuteLoader;
import org.junit.Assert;
import org.junit.Test;

/**
 * TODO ArMotozov
 *
 * @since 11/19/2022
 */
public class SortServiceTest {

	private SortService sortService = new SortService();

	@Test
	public void testSortServiceValuteByValueAscending() throws IOException {
		ValuteLoader loader = new ValuteLoader();
		List<Valute> valuteList = loader.loadValute("src/test/resources/currency_test.csv");
		List<Valute> sortedValuteList = sortService.sortByColumn(valuteList, Valute.Columns.VALUE, true);
		Assert.assertNotNull(sortedValuteList);
		Assert.assertEquals(valuteList.size(), sortedValuteList.size());
		Assert.assertNotSame(valuteList, sortedValuteList);
		for (int i = 0; i < sortedValuteList.size() - 1; i++) {
			Assert.assertTrue(sortedValuteList.get(i).getValue() <= sortedValuteList.get(i + 1).getValue());
		}
	}

	@Test
	public void testSortServiceValuteByValueDescending() throws IOException {
		ValuteLoader loader = new ValuteLoader();
		List<Valute> valuteList = loader.loadValute("src/test/resources/currency_test.csv");
		List<Valute> sortedValuteList = sortService.sortByColumn(valuteList, Valute.Columns.VALUE, false);
		Assert.assertNotNull(sortedValuteList);
		Assert.assertEquals(valuteList.size(), sortedValuteList.size());
		Assert.assertNotSame(valuteList, sortedValuteList);
		for (int i = 0; i < sortedValuteList.size() - 1; i++) {
			Assert.assertTrue(sortedValuteList.get(i).getValue() >= sortedValuteList.get(i + 1).getValue());
		}
	}

	@Test
	public void testSortServiceValuteByCodeAscending() throws IOException {
		ValuteLoader loader = new ValuteLoader();
		List<Valute> valuteList = loader.loadValute("src/test/resources/currency_test.csv");
		List<Valute> sortedValuteList = sortService.sortByColumn(valuteList, Valute.Columns.CURRENCY_CODE, true);
		Assert.assertNotNull(sortedValuteList);
		Assert.assertEquals(valuteList.size(), sortedValuteList.size());
		Assert.assertNotSame(valuteList, sortedValuteList);
		for (int i = 0; i < sortedValuteList.size() - 1; i++) {
			Assert.assertTrue(sortedValuteList.get(i).getCurrencyCode()
					                  .compareTo(sortedValuteList.get(i + 1).getCurrencyCode()) <= 0);
		}
	}

	@Test
	public void testSortServiceValuteByDateAscending() throws IOException {
		ValuteLoader loader = new ValuteLoader();
		List<Valute> valuteList = loader.loadValute("src/test/resources/currency_test.csv");
		List<Valute> sortedValuteList = sortService.sortByColumn(valuteList, Valute.Columns.DATE, true);
		Assert.assertNotNull(sortedValuteList);
		Assert.assertEquals(valuteList.size(), sortedValuteList.size());
		Assert.assertNotSame(valuteList, sortedValuteList);
		for (int i = 0; i < sortedValuteList.size() - 1; i++) {
			Assert.assertTrue(sortedValuteList.get(i).getDate().getTime() <= sortedValuteList.get(i + 1).getDate().getTime());
		}
	}
}










