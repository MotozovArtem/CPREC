package io.rienel.cw6.repository

import io.rienel.cw6.api.data.OfferRemoteData
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class OfferStatisticRepository @Inject constructor(
	private val offerRemoteData: OfferRemoteData
) {
	suspend fun getOfferStatistic() = offerRemoteData.getOfferStatistic()
}