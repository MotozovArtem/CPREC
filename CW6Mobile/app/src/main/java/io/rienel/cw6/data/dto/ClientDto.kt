package io.rienel.cw6.data.dto


import java.time.LocalDate

data class ClientDto(
	val id: String? = null,
	val surname: String? = null,
	val name: String? = null,
	val patronymic: String? = null,
	val sex: Boolean? = null,
	val birthDate: LocalDate? = null,
	val inn: String? = null,
	val passportSerial: String? = null,
	val phone: String? = null,
)