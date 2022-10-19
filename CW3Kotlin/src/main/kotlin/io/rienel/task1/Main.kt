import io.rienel.task1.LeasingOfferService
import io.rienel.task1.model.Client
import io.rienel.task1.model.Position
import io.rienel.task1.model.Stuff
import java.time.LocalDate
import java.util.*

fun main(args: Array<String>) {
    val client = Client(
        UUID.randomUUID(),
        surname = "Client",
        name = "Client",
        patronymic = "Client",
        sex = true,
        inn = "123556",
        passportSerial = "112314",
        phone = "1123124",
        birthDate = LocalDate.now()
    )
    val stuff = Stuff(
        UUID.randomUUID(),
        surname = "Client",
        name = "Client",
        patronymic = "Client",
        sex = true,
        birthDate = LocalDate.now(),
        salaryMultiplier = 1.11,
        position = Position(
            UUID.randomUUID(),
            "Менеджер",
            100000
        )
    )
    val signedOffer = LeasingOfferService.signNewOffer(LocalDate.now(), LocalDate.now().plusYears(1), client, stuff)
    println(signedOffer)
}