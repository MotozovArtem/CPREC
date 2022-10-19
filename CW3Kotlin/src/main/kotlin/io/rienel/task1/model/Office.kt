package io.rienel.task1.model

import java.util.*

data class Office(
    var id: UUID,
    var address: String,
    var lawAddress: String,
    var cabinetsCount: Int
)