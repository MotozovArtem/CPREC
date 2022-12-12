package io.rienel.cw6.server.service.impl;

import java.time.LocalDate;
import java.util.UUID;

import io.rienel.cw6.server.model.Client;
import io.rienel.cw6.server.model.Offer;
import io.rienel.cw6.server.model.Stuff;
import io.rienel.cw6.server.repository.OfferRepository;
import io.rienel.cw6.server.repository.OfficeRepository;
import io.rienel.cw6.server.service.OfferService;
import io.rienel.cw6.server.service.SerialNumberGeneratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * TODO ArMotozov
 *
 * @since 11/16/2022
 */
@Service
public class OfferServiceImpl implements OfferService {

	private final OfficeRepository officeRepository;

	private final OfferRepository offerRepository;

	private final SerialNumberGeneratorService serialNumberGenerator;

	@Autowired
	public OfferServiceImpl(final OfficeRepository officeRepository, final OfferRepository offerRepository, SerialNumberGeneratorService serialNumberGenerator) {
		this.officeRepository = officeRepository;
		this.offerRepository = offerRepository;
		this.serialNumberGenerator = serialNumberGenerator;
	}

	@Override
	public Offer signNewOffer(LocalDate startDate, LocalDate endingDate, Client client, Stuff stuff) {
		Offer newOffer = new Offer.Builder()
				.setId(UUID.randomUUID())
				.setSerialNumber(serialNumberGenerator.generateSerialNumber())
				.setClient(client)
				.setStuff(stuff)
				.setSignDate(LocalDate.now())
				.setStartDate(startDate)
				.setEndingDate(endingDate)
				.setOffice(officeRepository
						.findById(UUID.fromString("a68062fe-bac2-4408-af87-85ebd882d7a4"))
						.orElseThrow())
				.build();
		return offerRepository.save(newOffer);
	}
}
