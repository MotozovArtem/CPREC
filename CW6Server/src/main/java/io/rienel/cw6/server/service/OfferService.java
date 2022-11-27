package io.rienel.cw6.server.service;

import java.time.LocalDate;

import io.rienel.cw6.server.model.Client;
import io.rienel.cw6.server.model.Offer;
import io.rienel.cw6.server.model.Stuff;

/**
 * TODO ArMotozov
 *
 * @since 11/16/2022
 */
public interface OfferService {
	Offer signNewOffer(LocalDate startDate, LocalDate endingDate, Client client, Stuff stuff);
}
