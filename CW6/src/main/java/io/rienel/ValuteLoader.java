package io.rienel;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/**
 * TODO ArMotozov
 *
 * @since 11/19/2022
 */
public class ValuteLoader {
	public List<Valute> loadValute(String filename) throws IOException {
		if (filename == null) {
			return new ArrayList<>();
		}
		File file = new File(filename);
		Valute valute;
		List<Valute> valuteList = new ArrayList<>();
		try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
			boolean isHeader = true;
			String readedLine = reader.readLine();
			while (readedLine != null) {
				if (isHeader) {
					readedLine = reader.readLine();
					isHeader = false;
					continue;
				}
				String[] readedLineSplited = readedLine.split(",");
				valute = parseValute(readedLineSplited);
				valuteList.add(valute);
				readedLine = reader.readLine();
			}
		} catch (IOException e) {
			throw e;
		} catch (ParseException f) {
			f.printStackTrace();
		}
		return valuteList;
	}

	private Valute parseValute(String[] readedLineSplited) throws ParseException {
		Valute valute;
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
		valute = new Valute(
				readedLineSplited[0],
				Double.parseDouble(readedLineSplited[1]),
				Integer.parseInt(readedLineSplited[2]),
				readedLineSplited[3],
				readedLineSplited[4],
				formatter.parse(readedLineSplited[5])
		);
		return valute;
	}

	public List<Valute> loadValuteSorted(String fileName, ValuteColumn valuteColumn, Boolean direction) {
		return null;
	}
}
