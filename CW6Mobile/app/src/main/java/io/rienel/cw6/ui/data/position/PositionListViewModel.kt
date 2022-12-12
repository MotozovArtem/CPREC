package io.rienel.cw6.ui.data.position

import android.system.ErrnoException
import android.system.OsConstants
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import io.rienel.cw6.data.converter.toDomain
import io.rienel.cw6.data.dto.PositionDto
import io.rienel.cw6.data.model.Position
import io.rienel.cw6.repository.PositionRepository
import io.rienel.cw6.ui.util.ResponseResult
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

	val responseResult: MutableLiveData<ResponseResult> by lazy {
		MutableLiveData<ResponseResult>()
	}

	fun getPositions() {
		viewModelScope.launch {
			Timber.i("Requesting position information")
			val response: Response<List<PositionDto>>
			try {
				response = positionRepository.getPositions()
			} catch (e: Exception) {
				Timber.e(e, "Error while requesting position information")
				val errnoException = e.cause?.cause as ErrnoException?
				responseResult.value = when (errnoException?.errno) {
					OsConstants.EHOSTUNREACH -> ResponseResult.HOST_IS_UNREACHABLE
					OsConstants.ECONNREFUSED -> ResponseResult.CONNECTION_REFUSED
					else -> ResponseResult.UNKNOWN
				}
				return@launch
			}
			val positions = response.body()
			if (positions == null) {
				Timber.i("Positions DTO: empty response")
				responseResult.value = ResponseResult.EMPTY_RESPONSE
				return@launch
			}
			Timber.i("Received positions $positions")
			responseResult.value = ResponseResult.OK
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