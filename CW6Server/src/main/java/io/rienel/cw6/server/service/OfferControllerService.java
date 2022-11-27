package io.rienel.cw6.server.service;

import java.time.LocalDate;
import java.util.UUID;

import io.rienel.cw6.server.dto.OfferStatistic;
import io.rienel.cw6.server.model.Offer;

/**
 * Offer controller service.
 *
 * @since 11/27/2022
 */
public interface OfferControllerService {
	Offer signNewOffer(LocalDate startDate, LocalDate endingDate, UUID clientId, UUID stuffId);
}
