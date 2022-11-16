package io.rienel.cw6.server.controller;

import java.util.List;
import java.util.UUID;

import io.rienel.cw6.server.model.Offer;
import io.rienel.cw6.server.repository.OfferRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

	@Autowired
	public OfferController(OfferRepository offerRepository) {
		this.offerRepository = offerRepository;
	}

	@GetMapping("")
	public List<Offer> getOffer() {
		return offerRepository.findAll();
	}

	@GetMapping("/{id}")
	public Offer getOfferById(@PathVariable("id")UUID id) {
		return offerRepository.findById(id).orElse(null);
	}
}
