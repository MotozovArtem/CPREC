package io.rienel.cw6.data.converter

import io.rienel.cw6.data.dto.ClientDto
import io.rienel.cw6.data.dto.OfferDto
import io.rienel.cw6.data.dto.OfficeDto
import io.rienel.cw6.data.dto.PositionDto
import io.rienel.cw6.data.dto.StuffDto
import io.rienel.cw6.data.model.Client
import io.rienel.cw6.data.model.Offer
import io.rienel.cw6.data.model.Office
import io.rienel.cw6.data.model.Position
import io.rienel.cw6.data.model.Stuff


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
	stuffId = this.stuff!!.id!!,
	officeId = this.office!!.id!!,
)

fun OfficeDto.toDomain() = Office(
	officeId = this.id!!,
	address = this.address!!,
	lawAddress = this.lawAddress!!,
	cabinetsCount = this.cabinetsCount!!,
)

fun PositionDto.toDomain() = Position(
	positionId = this.id!!,
	name = this.name!!,
	salary = this.salary!!,
)

fun StuffDto.toDomain() = Stuff(
	stuffId = this.id!!,
	surname = this.surname!!,
	name = this.name!!,
	patronymic = this.patronymic!!,
	sex = this.sex!!,
	birthDate = this.birthDate!!,
	salaryMultiplier = this.salaryMultiplier!!,
	positionId = this.position!!.id!!,
)

