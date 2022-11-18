package io.rienel.cw6.model

import androidx.room.Embedded
import androidx.room.Relation

data class StuffInPosition(
    @Embedded val stuff: Stuff,
)
