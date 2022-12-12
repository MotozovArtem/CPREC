package io.rienel.cw6.data

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import io.rienel.cw6.data.dao.ClientDao
import io.rienel.cw6.data.dao.OfferDao
import io.rienel.cw6.data.dao.OfficeDao
import io.rienel.cw6.data.dao.PositionDao
import io.rienel.cw6.data.dao.StuffDao
import io.rienel.cw6.data.model.Client
import io.rienel.cw6.data.model.Offer
import io.rienel.cw6.data.model.Office
import io.rienel.cw6.data.model.Position
import io.rienel.cw6.data.model.Stuff
import io.rienel.cw6.data.util.LocalDateConverter

@Database(
	version = 1,
	entities = [
		Client::class,
		Offer::class,
		Office::class,
		Stuff::class,
		Position::class
	]
)
@TypeConverters(LocalDateConverter::class)
abstract class AppDatabase : RoomDatabase() {
	companion object {
		const val DATABASE_NAME = "Cw6"
	}

	abstract fun clientDao(): ClientDao
	abstract fun offerDao(): OfferDao
	abstract fun officeDao(): OfficeDao
	abstract fun positionDao(): PositionDao
	abstract fun stuffDao(): StuffDao
}