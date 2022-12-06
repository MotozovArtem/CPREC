package io.rienel.cw6.repository

import io.rienel.cw6.api.data.PositionRemoteData
import io.rienel.cw6.data.dao.PositionDao
import io.rienel.cw6.data.model.Position
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class PositionRepository @Inject constructor(
	private val positionDao: PositionDao,
	private val positionRemoteData: PositionRemoteData
) {
	val positions: Flow<List<Position>> = positionDao.getAll()

	suspend fun getPositions() = positionRemoteData.getPositions()

	fun saveAllPositions(positions: List<Position>) =
		positionDao.insertAll(*positions.toTypedArray())

	fun clear() = positionDao.deleteAll()
}