package io.rienel.cw6.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import io.rienel.cw6.data.model.Offer

@Dao
interface OfferDao {

	@Insert
	fun insert(offer: Offer)

	@Insert
	fun insertAll(vararg offers: Offer)

	@Query("DELETE FROM Offer")
	fun deleteAll()

	@Query("SELECT * FROM Offer")
	fun getAll(): List<Offer>
}