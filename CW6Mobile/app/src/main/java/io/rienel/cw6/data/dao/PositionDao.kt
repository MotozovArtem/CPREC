package io.rienel.cw6.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import io.rienel.cw6.data.model.Position

@Dao
interface PositionDao {

	@Insert
	fun insert(position: Position)

	@Insert
	fun insertAll(vararg positions: Position)

	@Query("DELETE FROM Position")
	fun deleteAll()

	@Query("SELECT * FROM Position")
	fun getAll(): List<Position>
}