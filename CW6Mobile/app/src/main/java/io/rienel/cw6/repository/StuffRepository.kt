package io.rienel.cw6.repository

import io.rienel.cw6.data.dao.StuffDao
import io.rienel.cw6.data.model.Stuff
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class StuffRepository @Inject constructor(
	private val stuffDao: StuffDao
) {
	val stuffs: Flow<List<Stuff>> = stuffDao.getAll()
}