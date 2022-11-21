package io.rienel;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/**
 * TODO ArMotozov
 *
 * @since 11/19/2022
 */
public class ValuteLoader {

	private static final int CSV_COLUMN_ID = 0;
	private static final int CSV_COLUMN_VALUE = 1;
	private static final int CSV_COLUMN_NOMINAL = 2;
	private static final int CSV_COLUMN_CURRENCY_NAME = 3;
	private static final int CSV_COLUMN_CURRENCY_CODE = 4;
	private static final int CSV_COLUMN_DATE = 5;


	public List<Valute> loadValute(String filename) throws IOException {
		if (filename == null) {
			throw new RuntimeException("Filename cannot be null");
		}
		List<Valute> valuteList = new ArrayList<>();
		try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
			reader.readLine(); // read header and ignore it
			String line = reader.readLine();
			while (line != null) {
				Valute valute = parseValute(line);
				line = reader.readLine();
				valuteList.add(valute);
			}
		} catch (IOException e) {
			throw e;
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return valuteList;
	}

	private Valute parseValute(String line) throws ParseException {
		Valute valute = new Valute();
		String[] split = line.split(",");
		valute.setId(split[CSV_COLUMN_ID]);
		valute.setValue(Double.parseDouble(split[CSV_COLUMN_VALUE]));
		valute.setNominal(Integer.parseInt(split[CSV_COLUMN_NOMINAL]));
		valute.setCurrencyName(split[CSV_COLUMN_CURRENCY_NAME]);
		valute.setCurrencyCode(split[CSV_COLUMN_CURRENCY_CODE]);
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
		Date date = formatter.parse(split[CSV_COLUMN_DATE]);
		valute.setDate(date);
		return valute;
	}
}
