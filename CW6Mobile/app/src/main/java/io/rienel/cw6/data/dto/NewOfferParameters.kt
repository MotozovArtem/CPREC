package io.rienel.cw6.data.dto

import java.time.LocalDate
import java.util.UUID

data class NewOfferParameters(
	val clientId: UUID,
	val stuffId: UUID,
	val startDate: LocalDate,
	val endingDate: LocalDate
)
