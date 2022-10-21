package io.rienel.cw4.test.dto;

import java.io.BufferedReader;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.Month;
import java.time.ZoneOffset;
import java.util.Date;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import io.rienel.dto.ValCurs;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ValCursXmlTest {

	private final XmlMapper mapper = new XmlMapper();

	@Test
	public void readValCursXmlTest() throws URISyntaxException, IOException {
		final StringBuilder xmlBuilder = new StringBuilder();
		try (BufferedReader reader = Files.newBufferedReader(
				Paths.get(
						ValCursXmlTest.class.getResource("/XML_daily.xml").toURI()),
				StandardCharsets.UTF_8)) {
			String line;
			while ((line = reader.readLine()) != null) {
				xmlBuilder.append(line);
			}
		}
		final String xml = xmlBuilder.toString();
		ValCurs valCurs = mapper.readValue(xml, ValCurs.class);

		assertEquals(Date.from(LocalDate.of(2002, Month.MARCH, 2).atStartOfDay()
				.toInstant(ZoneOffset.UTC)), valCurs.getDate());
		assertEquals("Foreign Currency Market", valCurs.getName());
		assertEquals(17, valCurs.getValuteList().size());

	}
}
