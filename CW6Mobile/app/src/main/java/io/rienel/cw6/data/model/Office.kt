package io.rienel.cw6.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Office(
	@PrimaryKey val officeId: String,
	@ColumnInfo(name = "address") val address: String,
	@ColumnInfo(name = "lawAddress") val lawAddress: String,
	@ColumnInfo(name = "cabinetsCount") val cabinetsCount: Int,
)
