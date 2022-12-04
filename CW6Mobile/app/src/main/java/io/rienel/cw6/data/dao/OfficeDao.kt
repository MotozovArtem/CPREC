package io.rienel.cw6.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import io.rienel.cw6.data.model.Office
import kotlinx.coroutines.flow.Flow

@Dao
interface OfficeDao {

	@Insert
	fun insert(office: Office)

	@Insert
	fun insertAll(vararg offices: Office)

	@Query("DELETE FROM Office")
	fun deleteAll()

	@Query("SELECT * FROM Office")
	fun getAll(): Flow<List<Office>>
}