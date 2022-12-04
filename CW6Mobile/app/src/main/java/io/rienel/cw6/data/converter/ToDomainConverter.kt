package io.rienel.cw6.data.converter

import io.rienel.cw6.data.dto.ClientDto
import io.rienel.cw6.data.dto.OfferDto
import io.rienel.cw6.data.model.Client
import io.rienel.cw6.data.model.Offer


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

fun OfferDto.toDomain() = Offer(
	offerId = this.id!!,
	serialNumber = this.serialNumber!!,
	endingDate = this.endingDate!!,
	signDate = this.signDate!!,
	startDate = this.startDate!!,
	clientId = this.client!!.id!!,
	stuffId = this.stuff!!.stuffId!!,
	officeId = this.office!!.id!!,
)