package io.rienel.cw6.repository

import io.rienel.cw6.data.dao.PositionDao
import io.rienel.cw6.data.model.Position
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.asFlow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class PositionRepository @Inject constructor(
	private val positionDao: PositionDao
) {
	val positions: Flow<Position> = positionDao.getAll().asFlow()
}