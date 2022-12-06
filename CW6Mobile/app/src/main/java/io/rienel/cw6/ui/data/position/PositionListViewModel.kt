package io.rienel.cw6.ui.data.position

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import io.rienel.cw6.data.converter.toDomain
import io.rienel.cw6.data.dto.PositionDto
import io.rienel.cw6.data.model.Position
import io.rienel.cw6.repository.PositionRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.Response
import timber.log.Timber
import javax.inject.Inject
import kotlin.streams.toList

@HiltViewModel
class PositionListViewModel @Inject constructor(
	private val positionRepository: PositionRepository
) : ViewModel() {

	val positionList: LiveData<List<Position>> = positionRepository
		.positions.asLiveData()

	fun getPositions() {
		viewModelScope.launch {
			Timber.i("Requesting position information")
			val response: Response<List<PositionDto>>
			try {
				response = positionRepository.getPositions()
			} catch (e: Exception) {
				Timber.e(e, "Error while requesting position information")
				return@launch
			}
			val positions = response.body()
			if (positions == null) {
				Timber.i("Positions DTO: empty response")
				return@launch
			}
			Timber.i("Received positions $positions")
			withContext(Dispatchers.IO) {
				synchronized(positionRepository) {
					positionRepository.clear()
					positionRepository.saveAllPositions(
						positions.stream()
							.map(PositionDto::toDomain)
							.toList()
					)
				}
			}

		}
	}
}