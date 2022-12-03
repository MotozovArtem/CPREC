package io.rienel.test;

import java.io.IOException;
import java.util.List;

import io.rienel.SearchService;
import io.rienel.Valute;
import io.rienel.ValuteLoader;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * TODO ArMotozov
 *
 * @since 12/3/2022
 */
public class SearchServiceTest {
	private SearchService searchService = new SearchService();

	private List<Valute> loadedValutes;

	@Before
	public void loadValutes() throws IOException {
		ValuteLoader loader = new ValuteLoader();
		loadedValutes = loader.loadValute("src/test/resources/currency_test.csv");
	}

	@Test
	public void testSearchByCurrencyCode() {
		String searchedCurrencyCode = "USD";
		List<Valute> findedValutes = searchService.searchValute(loadedValutes, searchedCurrencyCode, Valute.Columns.CURRENCY_CODE);
		Assert.assertNotNull(findedValutes);
		Assert.assertFalse(findedValutes.isEmpty());
		for (Valute valute : findedValutes) {
			Assert.assertTrue(valute.getCurrencyCode().contains(searchedCurrencyCode));
		}
	}

	@Test
	public void testSearchByCurrencyName() {
		String searchedCurrencyName = "Армянских драмов";
		List<Valute> findedValutes = searchService.searchValute(loadedValutes, searchedCurrencyName, Valute.Columns.CURRENCY_NAME);
		Assert.assertNotNull(findedValutes);
		Assert.assertFalse(findedValutes.isEmpty());
		for (Valute valute : findedValutes) {
			Assert.assertTrue(valute.getCurrencyName().contains(searchedCurrencyName));
		}
	}

	@Test
	public void testSearchByNominal() {
		String searchedCurrencyName = "Армянских драмов";
		List<Valute> findedValutes = searchService.searchValute(loadedValutes, searchedCurrencyName, Valute.Columns.NOMINAL);
		Assert.assertNotNull(findedValutes);
		Assert.assertTrue(findedValutes.isEmpty());
	}
}
