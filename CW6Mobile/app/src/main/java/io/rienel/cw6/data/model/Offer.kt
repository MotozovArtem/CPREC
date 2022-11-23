package io.rienel.cw6.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.time.LocalDate

@Entity
data class Offer(
	@PrimaryKey val offerId: String,
	@ColumnInfo(name = "serialNumber") val serialNumber: String,
	@ColumnInfo(name = "endingDate") val endingDate: LocalDate,
	@ColumnInfo(name = "signDate") val signDate: LocalDate,
	@ColumnInfo(name = "startDate") val startDate: LocalDate,
	@ColumnInfo(name = "clientId") val clientId: String,
	@ColumnInfo(name = "stuffId") val stuffId: String,
	@ColumnInfo(name = "officeId") val officeId: String,
)
