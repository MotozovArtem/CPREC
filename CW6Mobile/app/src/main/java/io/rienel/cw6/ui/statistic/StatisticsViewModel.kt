package io.rienel.cw6.ui.statistic

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import dagger.hilt.android.lifecycle.HiltViewModel
import io.rienel.cw6.data.dto.OfferStatistic
import io.rienel.cw6.repository.OfferStatisticRepository
import retrofit2.Response
import timber.log.Timber
import java.lang.Exception
import javax.inject.Inject

@HiltViewModel
class StatisticsViewModel @Inject constructor(
	private val offerStatisticRepository: OfferStatisticRepository
) : ViewModel() {
	fun getOfferStatistic(): LiveData<OfferStatistic?> {
		return liveData {
			val response: Response<OfferStatistic>
			try {
				response = offerStatisticRepository.getOfferStatistic()
			} catch (e: Exception) {
				emit(null)
				return@liveData
			}
			val offerStatistic = response.body()
			if (offerStatistic == null) {
				Timber.i("Offer Statistic: empty response")
			}
			emit(offerStatistic)
		}

	}
}