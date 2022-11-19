package io.rienel.test;

import java.io.IOException;
import java.util.List;

import io.rienel.Valute;
import io.rienel.ValuteColumn;
import io.rienel.ValuteLoader;
import org.junit.Test;

/**
 * TODO ArMotozov
 *
 * @since 11/19/2022
 */
public class SortTest {
	private ValuteLoader valuteLoader = new ValuteLoader();

	@Test
	public void testSortValueAsc() throws IOException {
		List<Valute> valuteList = valuteLoader.loadValuteSorted("src/test/resources/currency.csv", ValuteColumn.VALUE, true);

	}
}
