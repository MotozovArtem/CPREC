package io.rienel.task3;

import io.rienel.task1.OfferService;
import io.rienel.task1.model.Client;
import io.rienel.task1.model.Offer;
import io.rienel.task1.model.Office;
import io.rienel.task1.model.Stuff;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Random;
import java.util.Set;
import java.util.UUID;

public class LeasingOfferService implements OfferService {

    private final Office office;

    private static LeasingOfferService instance;

    private final List<Offer> offersList = new ArrayList<>();
    private final Map<String, Integer> stuffStatistics = new HashMap<>();
    private final Map<String, Integer> clientStatistics = new HashMap<>();
    private final Set<String> clientSurnames = new HashSet<>();

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
    public Offer signNewOffer(LocalDateTime startDate, LocalDateTime endingDate, Client client, Stuff stuff) {
        Objects.requireNonNull(startDate);
        Objects.requireNonNull(endingDate);
        Objects.requireNonNull(client);
        Objects.requireNonNull(stuff);

        Offer.Builder offerBuilder = new Offer.Builder();
        offerBuilder.setId(UUID.randomUUID())
                .setClient(client)
                .setStuff(stuff)
                .setOffice(office)
                .setSerialNumber(generateSerialNumber())
                .setSignDate(LocalDateTime.now())
                .setEndingDate(endingDate)
                .setStartDate(startDate);
        Offer offer = offerBuilder.build();
        offersList.add(offer);

        if (stuffStatistics.containsKey(offer.getStuff().getSurname())) {
            stuffStatistics.computeIfPresent(offer.getStuff().getSurname(), (k, v) -> v + 1);
        } else {
            stuffStatistics.put(offer.getStuff().getSurname(), 1);
        }
        if (clientStatistics.containsKey(offer.getClient().getSurname())) {
            clientStatistics.computeIfPresent(offer.getClient().getSurname(), (k, v) -> v + 1);
        } else {
            clientStatistics.put(offer.getClient().getSurname(), 1);
        }
        clientSurnames.add(offer.getClient().getSurname());
        return offer;
    }

    @Override
    public Offer findOfferBySerialNumber(String serialNumber) {
        for (Offer offer : offersList) {
            if (offer.getSerialNumber().equals(serialNumber)) {
                return offer;
            }
        }
        return null;
    }

    @Override
    public List<Offer> findOffersByClientSurname(String clientSurname) {
        List<Offer> resultList = new ArrayList<>();
        for (Offer offer : offersList) {
            if (offer.getClient().getSurname().equals(clientSurname)) {
                resultList.add(offer);
            }
        }
        return resultList;
    }

    @Override
    public List<Offer> findOffersByStuff(Stuff stuff) {
        List<Offer> resultList = new ArrayList<>();
        for (Offer offer : offersList) {
            if (offer.getStuff().getId().equals(stuff.getId())) {
                resultList.add(offer);
            }
        }
        return resultList;
    }
}
