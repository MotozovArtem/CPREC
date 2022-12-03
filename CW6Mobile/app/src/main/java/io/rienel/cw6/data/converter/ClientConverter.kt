package io.rienel.cw6.data.converter

import io.rienel.cw6.data.dto.ClientDto
import io.rienel.cw6.data.model.Client


fun ClientDto.toDomain() = Client(
	clientId = this.id!!,
	surname = this.surname!!,
	name = this.name!!,
	patronymic = this.patronymic!!,
	sex = this.sex!!,
	birthDate = this.birthDate!!,
	inn = this.inn!!,
	passportSerial = this.passportSerial!!,
	phone = this.phone!!
)
