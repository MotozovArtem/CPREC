package io.rienel.task1;

import io.rienel.task1.model.Client;
import io.rienel.task1.model.Offer;
import io.rienel.task1.model.Stuff;

import java.time.LocalDate;
import java.util.List;

public interface OfferService {
    Offer signNewOffer(LocalDate startDate, LocalDate endingDate,
                       Client client, Stuff stuff);

    Offer findOfferBySerialNumber(String serialNumber);

    List<Offer> findOffersByClientSurname(String clientSurname);

    List<Offer> findOffersByStuff(Stuff stuff);
}
