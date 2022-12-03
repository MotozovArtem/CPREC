package io.rienel.cw6.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import io.rienel.cw6.data.model.Client
import kotlinx.coroutines.flow.Flow

@Dao
interface ClientDao {

	@Insert
	fun insert(client: Client)

	@Insert
	fun insertAll(vararg clients: Client)

	@Query("DELETE FROM Client")
	fun deleteAll()

	@Query("SELECT * FROM Client")
	fun getAll(): Flow<List<Client>>
}