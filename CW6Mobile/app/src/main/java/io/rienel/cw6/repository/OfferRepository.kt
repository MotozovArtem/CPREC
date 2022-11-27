package io.rienel.cw6.repository

import io.rienel.cw6.data.dao.OfferDao
import io.rienel.cw6.data.model.Offer
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.asFlow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class OfferRepository @Inject constructor(
	private val offerDao: OfferDao
) {
	val offers: Flow<Offer> = offerDao.getAll().asFlow()
}