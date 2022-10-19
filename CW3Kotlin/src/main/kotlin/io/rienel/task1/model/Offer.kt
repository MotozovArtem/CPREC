package io.rienel.task1.model

import java.time.LocalDate
import java.util.*

data class Offer(
    var id: UUID,
    var serialNumber: String,
    var signDate: LocalDate,
    var endingDate: LocalDate,
    var startDate: LocalDate,
    var client: Client,
    var stuff: Stuff,
    var office: Office
)
