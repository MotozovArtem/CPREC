package io.rienel.cw6.ui.data.offer

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import io.rienel.cw6.data.converter.toDomain
import io.rienel.cw6.data.dto.OfferDto
import io.rienel.cw6.data.model.Offer
import io.rienel.cw6.repository.OfferRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.Response
import timber.log.Timber
import javax.inject.Inject
import kotlin.streams.toList

@HiltViewModel
class OfferListViewModel @Inject constructor(
	private val offerRepository: OfferRepository
) : ViewModel() {

	val offerList: LiveData<List<Offer>> = offerRepository
		.offers.asLiveData()

	fun getOffers() {
		viewModelScope.launch {
			Timber.i("Sending request for offer")
			val response: Response<List<OfferDto>>
			try {
				response = offerRepository.getOffers()
			} catch (e: Exception) {
				Timber.e(e, "Cannot obtain offer list")
				return@launch
			}
			val offers = response.body()
			if (offers == null) {
				Timber.i("Offer DTO: empty response")
				return@launch
			}
			Timber.i("Received offers $offers")
			withContext(Dispatchers.IO) {
				synchronized(offerRepository) {
					offerRepository.clear()
					offerRepository.saveAllOffers(
						offers
							.stream()
							.map(OfferDto::toDomain)
							.toList()
					)
				}
			}
		}
	}

}