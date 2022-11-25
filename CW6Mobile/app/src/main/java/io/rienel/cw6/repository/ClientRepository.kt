package io.rienel.cw6.repository

import io.rienel.cw6.data.dao.ClientDao
import io.rienel.cw6.data.model.Client
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.asFlow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ClientRepository @Inject constructor(
	private val clientDao: ClientDao
) {
	val clients: Flow<Client> = clientDao.getAll().asFlow()
}