package io.rienel.task1

import io.rienel.task1.model.Client
import io.rienel.task1.model.Offer
import io.rienel.task1.model.Stuff
import java.time.LocalDate

interface OfferService {
    fun signNewOffer(startDate: LocalDate, endingDate: LocalDate, client: Client, stuff: Stuff): Offer

    fun findOfferBySerialNumber(serialNumber: String): Offer

    fun findOffersByClientSurname(surname: String): List<Offer>

    fun findOffersByStuff(stuff: Stuff): List<Offer>
}