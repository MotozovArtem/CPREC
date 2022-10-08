package io.rienel.task1;

import static org.junit.jupiter.api.Assertions.*;

import io.rienel.task1.model.Client;
import io.rienel.task1.model.Offer;
import io.rienel.task1.model.Stuff;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.Comparator;

public class LeasingOfferServiceTest {

    OfferService offerService = new LeasingOfferService();
    Client client;
    Stuff stuff;


    @BeforeAll
    public static void initData() {

    }

    @AfterAll
    public static void clearData() {

    }

    @Test
    public void testOfferServiceInstantiating() {
        Offer offer = offerService.signNewOffer(LocalDateTime.now(), LocalDateTime.now(), client, stuff);
        assertNotNull(offer);
        assertNotNull(offer.getClient());
        assertNotNull(offer.getOffice());
        assertNotNull(offer.getStuff());
        assertNotNull(offer.getSignDate());
        assertNotNull(offer.getStartDate());
        assertNotNull(offer.getEndingDate());
        assertTrue(offer.getStartDate().compareTo(offer.getEndingDate()) < 0);
    }
}
