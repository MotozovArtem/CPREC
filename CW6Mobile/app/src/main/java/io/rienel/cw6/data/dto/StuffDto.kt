package io.rienel.cw6.data.dto

import java.time.LocalDate

data class StuffDto(
	val stuffId: String? = null,
	val surname: String? = null,
	val name: String? = null,
	val patronymic: String? = null,
	val sex: String? = null,
	val birthDate: LocalDate? = null,
	val salaryMultiplier: String? = null,
	val position: PositionDto? = null,
)