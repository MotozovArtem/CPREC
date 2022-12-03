package io.rienel.cw6.api.data

import io.rienel.cw6.api.Cw6ServerService
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ClientRemoteData @Inject constructor(
	private val serverService: Cw6ServerService
) {
	suspend fun getClients() = serverService.getAllClients()
}
