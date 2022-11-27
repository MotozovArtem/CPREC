package io.rienel.cw6.api.data

import io.rienel.cw6.api.Cw6ServerService
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class OfferStatisticRemoteData @Inject constructor(
	private val serverService: Cw6ServerService
) {
	suspend fun getOfferStatistic() = serverService.getOfferStatistic()
}