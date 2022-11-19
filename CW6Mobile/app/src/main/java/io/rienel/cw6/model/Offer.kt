package io.rienel.cw6.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.time.LocalDate

@Entity
data class Offer(
    @PrimaryKey val offer_id: String,
    @ColumnInfo(name = "serial_number") val serialNumber: String,
    @ColumnInfo(name = "ending_date") val endingDate: LocalDate,
    @ColumnInfo(name = "sign_date") val signDate: LocalDate,
    @ColumnInfo(name = "start_date") val startDate: LocalDate,
)
