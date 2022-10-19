package io.rienel.task1.model

import java.time.LocalDate
import java.util.*

data class Stuff(
    var id: UUID,
    var surname: String,
    var name: String,
    var patronymic: String,
    var sex: Boolean,
    var birthDate: LocalDate,
    var salaryMultiplier: Double,
    var position: Position
)