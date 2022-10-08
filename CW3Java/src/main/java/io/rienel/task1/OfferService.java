package io.rienel.task1;

import io.rienel.task1.model.Client;
import io.rienel.task1.model.Offer;
import io.rienel.task1.model.Stuff;

import java.time.LocalDateTime;
import java.util.List;

public interface OfferService {
    Offer signNewOffer(LocalDateTime startDate, LocalDateTime endingDate,
                       Client client, Stuff stuff);

    Offer findOfferBySerialNumber(String serialNumber);

    List<Offer> findOffersByClientSurname(String clientSurname);

    List<Offer> findOffersByStuff(Stuff stuff);
}
