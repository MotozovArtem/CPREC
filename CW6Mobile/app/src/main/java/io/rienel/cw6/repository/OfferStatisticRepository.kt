package io.rienel.cw6.repository

import io.rienel.cw6.api.data.OfferStatisticRemoteData
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class OfferStatisticRepository @Inject constructor(
	private val offerStatisticRemoteData: OfferStatisticRemoteData
){
	suspend fun getOfferStatistic() = offerStatisticRemoteData.getOfferStatistic()
}