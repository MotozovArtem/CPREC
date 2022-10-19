package io.rienel.task3

import io.rienel.task1.OfferService
import io.rienel.task1.model.Client
import io.rienel.task1.model.Offer
import io.rienel.task1.model.Office
import io.rienel.task1.model.Stuff
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.*
import java.util.stream.Collectors
import kotlin.random.Random
import kotlin.random.nextInt

object Task3LeasingOfferService : OfferService {

    private val signedOffers: MutableList<Offer> = mutableListOf()
    private val signedOfferByStuff: MutableMap<String, Int> = mutableMapOf()
    private val signedOfferWithClient: MutableMap<String, Int> = mutableMapOf()

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
        signedOffers.add(offer)
        if (stuff.id.toString() in signedOfferByStuff) {
            signedOfferByStuff.computeIfPresent(stuff.id.toString()) { _, v -> v + 1 }
        } else {
            signedOfferByStuff.put(stuff.id.toString(), 1)
        }
        if (client.id.toString() in signedOfferWithClient) {
            signedOfferByStuff.computeIfPresent(client.id.toString()) { _, v -> v + 1 }
        } else {
            signedOfferByStuff.put(client.id.toString(), 1)
        }
        return offer
    }

    override fun findOfferBySerialNumber(serialNumber: String): Offer = signedOffers.stream()
        .filter { it.serialNumber == serialNumber }
        .findFirst()
        .orElseThrow { IllegalStateException() }

    override fun findOffersByClientSurname(surname: String): List<Offer> = signedOffers.stream()
        .filter { it.client.surname == surname }
        .collect(Collectors.toList())

    override fun findOffersByStuff(stuff: Stuff): List<Offer> = signedOffers.stream()
        .filter { it.stuff == stuff }
        .collect(Collectors.toList())
}