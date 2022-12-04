package io.rienel.cw6.repository

import io.rienel.cw6.data.dao.OfficeDao
import io.rienel.cw6.data.model.Office
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.asFlow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class OfficeRepository @Inject constructor(
	private val officeDao: OfficeDao
) {
	val offices: Flow<List<Office>> = officeDao.getAll()
}