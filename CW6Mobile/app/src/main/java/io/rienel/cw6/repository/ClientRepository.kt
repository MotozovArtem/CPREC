package io.rienel.cw6.repository

import io.rienel.cw6.api.data.ClientRemoteData
import io.rienel.cw6.data.dao.ClientDao
import io.rienel.cw6.data.model.Client
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ClientRepository @Inject constructor(
	private val clientDao: ClientDao,
	private val clientRemoteData: ClientRemoteData
) {
	val clients: Flow<List<Client>> = clientDao.getAll()

	fun saveClient(client: Client) = clientDao.insert(client)

	fun saveAllClients(clients: List<Client>) = clientDao.insertAll(*clients.toTypedArray())

	fun clear() = clientDao.deleteAll()

	suspend fun getClients() = clientRemoteData.getClients()
}