package io.rienel.cw6.model

import androidx.room.Embedded
import androidx.room.Relation

data class StuffsInPosition(
    @Embedded val position: Position,
    @Relation(
        parentColumn = "position_id",

    )
    val stuffs: List<Stuff>
)
