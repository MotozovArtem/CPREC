package io.rienel.cw6.server.service.impl;

import java.time.LocalDate;
import java.util.Objects;
import java.util.UUID;

import io.rienel.cw6.server.dto.OfferStatistic;
import io.rienel.cw6.server.model.Client;
import io.rienel.cw6.server.model.Offer;
import io.rienel.cw6.server.model.Stuff;
import io.rienel.cw6.server.repository.ClientRepository;
import io.rienel.cw6.server.repository.OfferRepository;
import io.rienel.cw6.server.repository.StuffRepository;
import io.rienel.cw6.server.service.OfferControllerService;
import io.rienel.cw6.server.service.OfferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Offer controller service implementation.
 *
 * @since 11/27/2022
 */
@Service
public class OfferControllerServiceImpl implements OfferControllerService {

	private final ClientRepository clientRepository;

	private final StuffRepository stuffRepository;

	private final OfferService offerService;

	@Autowired
	public OfferControllerServiceImpl(final ClientRepository clientRepository,
	                                  final StuffRepository stuffRepository,
	                                  final OfferService offerService) {
		this.clientRepository = clientRepository;
		this.stuffRepository = stuffRepository;
		this.offerService = offerService;
	}

	@Override
	public Offer signNewOffer(LocalDate startDate, LocalDate endingDate, UUID clientId, UUID stuffId) {
		Objects.requireNonNull(startDate);
		Objects.requireNonNull(endingDate);
		Objects.requireNonNull(clientId);
		Objects.requireNonNull(stuffId);

		final Client client = clientRepository.findById(clientId).orElseThrow();
		final Stuff stuff = stuffRepository.findById(stuffId).orElseThrow();
		return offerService.signNewOffer(startDate, endingDate, client, stuff);
	}

}
