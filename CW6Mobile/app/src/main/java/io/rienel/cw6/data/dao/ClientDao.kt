package io.rienel.cw6.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import io.rienel.cw6.data.model.Client

@Dao
interface ClientDao {

	@Insert
	fun insert(client: Client)

	@Insert
	fun insertAll(vararg clients: Client)

	@Query("DELETE FROM Client")
	fun deleteAll()

	@Query("SELECT * FROM Client")
	fun getAll(): List<Client>
}