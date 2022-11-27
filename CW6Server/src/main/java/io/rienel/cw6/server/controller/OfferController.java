package io.rienel.cw6.server.controller;

import java.util.List;
import java.util.Objects;
import java.util.UUID;

import io.rienel.cw6.server.dto.NewOfferParameters;
import io.rienel.cw6.server.dto.OfferStatistic;
import io.rienel.cw6.server.model.Offer;
import io.rienel.cw6.server.repository.OfferRepository;
import io.rienel.cw6.server.service.OfferControllerService;
import io.rienel.cw6.server.service.OfferStatisticService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * TODO ArMotozov
 *
 * @since 11/16/2022
 */
@RestController
@RequestMapping("/api/v1/offer")
public class OfferController {

	private final OfferRepository offerRepository;

	private final OfferControllerService offerService;

	private final OfferStatisticService offerStatisticService;

	@Autowired
	public OfferController(final OfferRepository offerRepository,
	                       final OfferControllerService offerService,
	                       final OfferStatisticService offerStatisticService) {
		this.offerRepository = offerRepository;
		this.offerService = offerService;
		this.offerStatisticService = offerStatisticService;
	}

	@GetMapping("")
	public List<Offer> getOffer() {
		return offerRepository.findAll();
	}

	@GetMapping("/{id}")
	public Offer getOfferById(@PathVariable("id") UUID id) {
		return offerRepository.findById(id).orElse(null);
	}

	@PutMapping("")
	public Offer signNewOffer(@RequestBody NewOfferParameters offerParameters) {
		Objects.requireNonNull(offerParameters);
		Objects.requireNonNull(offerParameters.getClientId());
		Objects.requireNonNull(offerParameters.getStuffId());
		Objects.requireNonNull(offerParameters.getStartDate());
		Objects.requireNonNull(offerParameters.getEndingDate());

		return offerService.signNewOffer(
				offerParameters.getStartDate(),
				offerParameters.getEndingDate(),
				offerParameters.getClientId(),
				offerParameters.getStuffId());
	}

	@GetMapping("/statistic")
	public OfferStatistic getOfferStatistic() {
		return offerStatisticService.getOfferStatistic();
	}
}
