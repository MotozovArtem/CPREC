package io.rienel.test;

import java.util.Date;

import io.rienel.Valute;
import org.junit.Assert;
import org.junit.Test;

/**
 * TODO ArMotozov
 *
 * @since 12/3/2022
 */
public class ValuteOutputTest {
	@Test
	public void testValuteToCliUi() {
		Valute valute = new Valute("1",
				100.0,
				1,
				"Chervonec",
				"CHIRIK",
				new Date());
		String expectedValuteOutput = "1 100.00 Рублей = 1 Chervonec (CHIRIK)";
		Assert.assertEquals(expectedValuteOutput, valute.toString());

		valute = new Valute("1",
				18937456.532873,
				875346783,
				"",
				"",
				new Date());
		expectedValuteOutput = "1 18937456.53 Рублей = 875346783 NULL (NULL)";
		Assert.assertEquals(expectedValuteOutput, valute.toString());


		valute = new Valute();
		expectedValuteOutput = "NULL NULL Рублей = NULL NULL (NULL)";
		Assert.assertEquals(expectedValuteOutput, valute.toString());
	}

}
