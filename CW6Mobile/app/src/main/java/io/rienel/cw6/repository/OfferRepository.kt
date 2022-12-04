package io.rienel.cw6.repository

import io.rienel.cw6.api.data.OfferRemoteData
import io.rienel.cw6.data.dao.OfferDao
import io.rienel.cw6.data.model.Offer
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.asFlow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class OfferRepository @Inject constructor(
	private val offerDao: OfferDao,
	private val offerRemoteData: OfferRemoteData
) {
	val offers: Flow<List<Offer>> = offerDao.getAll()

	fun saveAllOffers(offers: List<Offer>) = offerDao.insertAll(* offers.toTypedArray())

	fun clear() = offerDao.deleteAll()

	suspend fun getOffers() = offerRemoteData.getOffers()
}