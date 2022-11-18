package io.rienel.cw6.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.time.LocalDate

@Entity
data class Client(
    @PrimaryKey val id: String,
    @ColumnInfo(name = "surname")         val surname: String,
    @ColumnInfo(name = "name")            val name: String,
    @ColumnInfo(name = "patronymic")      val patronymic: String,
    @ColumnInfo(name = "sex")             val sex: String,
    @ColumnInfo(name = "birth_date")      val birthDate: LocalDate,
    @ColumnInfo(name = "inn")             val inn: String,
    @ColumnInfo(name = "passport_serial") val passportSerial: String,
    @ColumnInfo(name = "phone")           val phone: String,
)
