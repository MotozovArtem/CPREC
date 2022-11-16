package io.rienel.cw6.server.service;

import java.time.LocalDateTime;

import io.rienel.cw6.server.model.Client;
import io.rienel.cw6.server.model.Offer;
import io.rienel.cw6.server.model.Stuff;

/**
 * TODO ArMotozov
 *
 * @since 11/16/2022
 */
public interface OfferService {
	Offer signNewOffer(LocalDateTime startDate, LocalDateTime endingDate,
	                   Client client, Stuff stuff);
}
