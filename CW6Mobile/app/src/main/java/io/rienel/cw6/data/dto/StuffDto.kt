package io.rienel.cw6.data.dto

import java.time.LocalDate

data class StuffDto(
	val id: String? = null,
	val surname: String? = null,
	val name: String? = null,
	val patronymic: String? = null,
	val sex: String? = null,
	val birthDate: LocalDate? = null,
	val salaryMultiplier: Double? = null,
	val position: PositionDto? = null,
)