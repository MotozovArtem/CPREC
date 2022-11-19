package io.rienel.cw6.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.time.LocalDate
import java.util.*

@Entity
data class Stuff(
    @PrimaryKey                             val id: String,
    @ColumnInfo(name = "surname")           val surname: String,
    @ColumnInfo(name = "name")              val name: String,
    @ColumnInfo(name = "patronymic")        val patronymic: String,
    @ColumnInfo(name = "sex")               val sex: String,
    @ColumnInfo(name = "birthDate")         val birthDate: LocalDate,
    @ColumnInfo(name = "salary_multiplier") val salaryMultiplier: String,
    @ColumnInfo(name = "position_id")       val positionId: String,
)
