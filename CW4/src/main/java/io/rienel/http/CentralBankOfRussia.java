package io.rienel.http;

import java.util.Objects;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import retrofit.RestAdapter;
import retrofit.converter.JacksonConverter;

public final class CentralBankOfRussia {

	public static final String CBR_URL = "https://cbr.ru/";

	private static final Logger log = LoggerFactory.getLogger(CentralBankOfRussia.class);

	private CentralBankOfRussia() {
		throw new IllegalStateException();
	}

	public static CentralBankOfRussianService newClient(String uri) {
		Objects.requireNonNull(uri);

		log.debug("Creating new {} instance with uri: {}", CentralBankOfRussianService.class.getSimpleName(), uri);
		RestAdapter restAdapter = new RestAdapter.Builder()
				.setLog(new LogAdapter(log))
				.setEndpoint(uri)
				.setConverter(new JacksonConverter(new XmlMapper()))
				.build();

		return restAdapter.create(CentralBankOfRussianService.class);
	}

	private static class LogAdapter implements RestAdapter.Log {
		private final Logger log;

		public LogAdapter(Logger log) {
			Objects.requireNonNull(log);
			this.log = log;
		}

		@Override
		public void log(String message) {
			log.debug(message);
		}
	}
}
