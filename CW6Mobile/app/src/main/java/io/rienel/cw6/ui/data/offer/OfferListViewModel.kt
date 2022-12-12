package io.rienel.cw6.ui.data.offer

import android.system.ErrnoException
import android.system.OsConstants
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import io.rienel.cw6.data.converter.toDomain
import io.rienel.cw6.data.dto.OfferDto
import io.rienel.cw6.data.model.Offer
import io.rienel.cw6.repository.OfferRepository
import io.rienel.cw6.ui.util.ResponseResult
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

	val responseResult: MutableLiveData<ResponseResult> by lazy {
		MutableLiveData<ResponseResult>()
	}

	fun getOffers() {
		viewModelScope.launch {
			Timber.i("Sending request for offer")
			val response: Response<List<OfferDto>>
			try {
				response = offerRepository.getOffers()
			} catch (e: Exception) {
				Timber.e(e, "Cannot obtain offer list")
				val errnoException = e.cause?.cause as ErrnoException?
				responseResult.value = when (errnoException?.errno) {
					OsConstants.EHOSTUNREACH -> ResponseResult.HOST_IS_UNREACHABLE
					OsConstants.ECONNREFUSED -> ResponseResult.CONNECTION_REFUSED
					else -> ResponseResult.UNKNOWN
				}
				return@launch
			}
			val offers = response.body()
			if (offers == null) {
				Timber.i("Offer DTO: empty response")
				responseResult.value = ResponseResult.EMPTY_RESPONSE
				return@launch
			}
			Timber.i("Received offers $offers")
			responseResult.value = ResponseResult.OK
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