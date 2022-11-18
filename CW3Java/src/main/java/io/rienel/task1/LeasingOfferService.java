package io.rienel.task1;

import io.rienel.task1.model.Client;
import io.rienel.task1.model.Offer;
import io.rienel.task1.model.Office;
import io.rienel.task1.model.Stuff;

import java.time.LocalDate;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Random;
import java.util.UUID;

public class LeasingOfferService implements OfferService {

    private final Office office;

    private static LeasingOfferService instance;

    private LeasingOfferService() {
        office = new Office();
        office.setId(UUID.randomUUID());
        office.setAddress("Москва, Стромынка");
        office.setLawAddress("Москва, пр-т. Вернадского");
        office.setCabinetsCount(100);
    }

    public static LeasingOfferService getInstance() {
        if (instance == null) {
            instance = new LeasingOfferService();
        }
        return instance;
    }


    public String generateSerialNumber() {
        return String.format("№228%d%s", new Random().nextInt(10),
                DateTimeFormatter.ISO_DATE.format(LocalDate.now()));
    }

    @Override
    public Offer signNewOffer(LocalDate startDate, LocalDate endingDate, Client client, Stuff stuff) {
        Offer.Builder offerBuilder = new Offer.Builder();
        offerBuilder.setId(UUID.randomUUID())
                .setClient(client)
                .setStuff(stuff)
                .setOffice(office)
                .setSerialNumber(generateSerialNumber())
                .setSignDate(LocalDate.now())
                .setEndingDate(endingDate)
                .setStartDate(startDate);
        return offerBuilder.build();
    }

    //region
    @Override
    public Offer findOfferBySerialNumber(String serialNumber) {
        // todo armotozov
        return null;
    }

    @Override
    public List<Offer> findOffersByClientSurname(String clientSurname) {
        // todo armotozov
        return null;
    }

    @Override
    public List<Offer> findOffersByStuff(Stuff stuff) {
        // todo armotozov
        return null;
    }
    //endregion
}
