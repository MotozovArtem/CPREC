package io.rienel.task1

import io.rienel.task1.model.Client
import io.rienel.task1.model.Offer
import io.rienel.task1.model.Office
import io.rienel.task1.model.Stuff
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.*
import kotlin.random.Random
import kotlin.random.nextInt

object LeasingOfferService : OfferService {

    private var office: Office = Office(
        UUID.randomUUID(),
        "Москва, Стромынка",
        "Москва, пр-т Вернадского",
        20
    )

    private fun generateSerialNumber(): String {
        val i = Random.nextInt(1..10)
        val j = DateTimeFormatter.ISO_DATE.format(LocalDate.now())
        return String.format("№3450D$i$j")
    }

    override fun signNewOffer(startDate: LocalDate, endingDate: LocalDate, client: Client, stuff: Stuff): Offer {
        val offer = Offer(
            id = UUID.randomUUID(),
            serialNumber = generateSerialNumber(),
            signDate = LocalDate.now(),
            endingDate = endingDate,
            startDate = startDate,
            client = client,
            stuff = stuff,
            office = office
        )
        return offer
    }

    override fun findOfferBySerialNumber(serialNumber: String): Offer {
        TODO("Not yet implemented")
    }

    override fun findOffersByClientSurname(surname: String): List<Offer> {
        TODO("Not yet implemented")
    }

    override fun findOffersByStuff(stuff: Stuff): List<Offer> {
        TODO("Not yet implemented")
    }
}