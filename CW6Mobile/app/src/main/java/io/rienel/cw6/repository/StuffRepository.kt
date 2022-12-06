package io.rienel.cw6.repository

import io.rienel.cw6.api.data.StuffRemoteData
import io.rienel.cw6.data.dao.StuffDao
import io.rienel.cw6.data.model.Stuff
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class StuffRepository @Inject constructor(
	private val stuffDao: StuffDao,
	private val stuffRemoteData: StuffRemoteData,
) {
	val stuffs: Flow<List<Stuff>> = stuffDao.getAll()

	fun saveAllStuffs(stuff: List<Stuff>) = stuffDao.insertAll(*stuff.toTypedArray())

	fun clear() = stuffDao.deleteAll()

	suspend fun getStuffs() = stuffRemoteData.getStuffs()
}