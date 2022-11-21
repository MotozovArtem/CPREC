package io.rienel.cw6.model

import androidx.room.Embedded
import androidx.room.Relation

data class StuffsInPosition(
    @Embedded val position: Position,
    @Relation(
        parentColumn = "positionId",
        entityColumn = "stuffPositionId"
    )
    val stuffs: List<Stuff>
)
