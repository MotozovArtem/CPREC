package io.rienel;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.Charset;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import io.rienel.dto.ValCurs;
import io.rienel.dto.Valute;
import io.rienel.http.CbrService;
import retrofit.RestAdapter;
import retrofit.converter.JacksonConverter;

public class Main {
	public static void main(String[] args) throws IOException {
		RestAdapter retrofit = new RestAdapter.Builder()
				.setEndpoint("https://www.cbr.ru/")
				.setConverter(new JacksonConverter(new XmlMapper()))
				.build();

		CbrService cbrService = retrofit.create(CbrService.class);

		ValCurs exchange = cbrService.getExchange("22/10/2022");
//		BufferedReader reader = new BufferedReader(
//				new FileReader("src/main/resources/XML_daily.xml",
//						Charset.forName("windows-1251")
//				)
//		);
//		StringBuilder builder = new StringBuilder();
//		String line = reader.readLine();
//		do {
//			builder.append(line);
//		} while ((line = reader.readLine()) != null);
//		reader.close();
//		String xmlContent = builder.toString();
//		XmlMapper xmlMapper = new XmlMapper();
//		ValCurs curs = xmlMapper.readValue(xmlContent, ValCurs.class);
		for(Valute value: exchange.getValuteList()) {
			System.out.println(value);
		}
	}
}
