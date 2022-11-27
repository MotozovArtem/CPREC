package io.rienel.cw6.ui.main

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import io.rienel.cw6.api.Cw6ServerService
import io.rienel.cw6.api.DynamicHostService
import io.rienel.cw6.repository.OfferRepository
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
	private val serverService: Cw6ServerService,
	private val dynamicServerIpService: DynamicHostService
) : ViewModel() {
//	fun getOffer(offerId: Int): LiveData<Offer> {
//		return liveData {
//			val data = offerRepository.offers
//		}
//	}

	@Throws(IllegalArgumentException::class)
	fun setServerIp(serverIp: String) {
		if (serverIp.isEmpty() || serverIp.isBlank()) {
			throw IllegalArgumentException()
		}
		dynamicServerIpService.serverIp.value = serverIp
	}
}