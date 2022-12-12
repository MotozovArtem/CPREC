package io.rienel.cw6.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.time.LocalDate

@Entity
data class Client(
	@PrimaryKey val clientId: String,
	@ColumnInfo(name = "surname") val surname: String,
	@ColumnInfo(name = "name") val name: String,
	@ColumnInfo(name = "patronymic") val patronymic: String,
	@ColumnInfo(name = "sex") val sex: Boolean,
	@ColumnInfo(name = "birthDate") val birthDate: LocalDate,
	@ColumnInfo(name = "inn") val inn: String,
	@ColumnInfo(name = "passportSerial") val passportSerial: String,
	@ColumnInfo(name = "phone") val phone: String,
)
