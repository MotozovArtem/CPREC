package io.rienel.cw6.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import dagger.hilt.android.lifecycle.HiltViewModel
import io.rienel.cw6.api.Cw6ServerService
import io.rienel.cw6.data.dao.OfferDao
import io.rienel.cw6.data.model.Offer
import io.rienel.cw6.repository.OfferRepository
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
	private val serverService: Cw6ServerService,
	private val offerRepository: OfferRepository
): ViewModel() {
	fun getOffer(offerId: Int): LiveData<Offer> {
		return liveData {
			val data = offerRepository.offers
		}
	}
}