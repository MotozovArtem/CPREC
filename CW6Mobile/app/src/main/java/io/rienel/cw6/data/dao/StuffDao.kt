package io.rienel.cw6.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import io.rienel.cw6.data.model.Stuff
import kotlinx.coroutines.flow.Flow

@Dao
interface StuffDao {

	@Insert
	fun insert(stuff: Stuff)

	@Insert
	fun insertAll(vararg stuffs: Stuff)

	@Query("DELETE FROM Stuff")
	fun deleteAll()

	@Query("SELECT * FROM Stuff")
	fun getAll(): Flow<List<Stuff>>

}