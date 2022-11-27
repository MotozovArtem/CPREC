package io.rienel.cw6.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import dagger.hilt.android.lifecycle.HiltViewModel
import io.rienel.cw6.data.dto.OfferStatistic
import io.rienel.cw6.repository.OfferStatisticRepository
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class StatisticsViewModel @Inject constructor(
	private val offerStatisticRepository: OfferStatisticRepository
) : ViewModel() {
	fun getOfferStatistic(): LiveData<OfferStatistic> {
		return liveData {
			val response = offerStatisticRepository.getOfferStatistic()
			val offerStatistic = response.body()
			if (offerStatistic == null) {
				Timber.i("Offer Statistic: empty response")
				return@liveData
			}
			emit(offerStatistic)
		}

	}
}