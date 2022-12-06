package io.rienel.cw6.repository

import io.rienel.cw6.api.data.OfficeRemoteData
import io.rienel.cw6.data.dao.OfficeDao
import io.rienel.cw6.data.model.Office
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class OfficeRepository @Inject constructor(
	private val officeDao: OfficeDao,
	private val officeRemoteData: OfficeRemoteData,
) {
	val offices: Flow<List<Office>> = officeDao.getAll()

	fun saveAllOffices(offices: List<Office>) = officeDao.insertAll(*offices.toTypedArray())

	fun clear() = officeDao.deleteAll()

	suspend fun getOffices() = officeRemoteData.getOffices()
}