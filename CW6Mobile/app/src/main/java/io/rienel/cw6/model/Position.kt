package io.rienel.cw6.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Position(
    @PrimaryKey val positionId: String,
    @ColumnInfo(name = "name") val name: String,
    @ColumnInfo(name = "salary") val salary: Int,
)
