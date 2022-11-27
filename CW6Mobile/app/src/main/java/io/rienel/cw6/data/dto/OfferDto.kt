package io.rienel.cw6.data.dto

import java.time.LocalDate

data class OfferDto(
	val id: String? = null,
	val serialNumber: String? = null,
	val endingDate: LocalDate? = null,
	val signDate: LocalDate? = null,
	val startDate: LocalDate? = null,
	val client: ClientDto? = null,
	val stuff: StuffDto? = null,
	val office: OfficeDto? = null,
)