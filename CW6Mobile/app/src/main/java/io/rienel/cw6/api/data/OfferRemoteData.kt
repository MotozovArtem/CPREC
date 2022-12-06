package io.rienel.cw6.api.data

import io.rienel.cw6.api.Cw6ServerService
import io.rienel.cw6.data.dto.NewOfferParameters
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class OfferRemoteData @Inject constructor(
	private val serverService: Cw6ServerService
) {
	suspend fun getOffers() = serverService.getAllOffers()

	suspend fun getOfferStatistic() = serverService.getOfferStatistic()

	suspend fun newOffer(newOfferParameters: NewOfferParameters) =
		serverService.signNewOffer(newOfferParameters)
}