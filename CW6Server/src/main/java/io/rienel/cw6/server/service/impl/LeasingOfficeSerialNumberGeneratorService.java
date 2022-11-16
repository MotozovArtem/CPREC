package io.rienel.cw6.server.service.impl;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;

import io.rienel.cw6.server.service.SerialNumberGeneratorService;
import org.springframework.stereotype.Service;

/**
 * TODO ArMotozov
 *
 * @since 11/16/2022
 */
@Service
public class LeasingOfficeSerialNumberGeneratorService implements SerialNumberGeneratorService {

	private final Random random = new Random();

	@Override
	public String generateSerialNumber() {
		return String.format("#77%s%s",
				random.nextInt(),
				LocalDateTime
						.now()
						.format(DateTimeFormatter.ISO_DATE)
						.replace("-", ""));
	}
}
