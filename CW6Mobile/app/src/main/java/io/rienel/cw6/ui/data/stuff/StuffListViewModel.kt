package io.rienel.cw6.ui.data.stuff

import android.system.ErrnoException
import android.system.OsConstants
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import io.rienel.cw6.data.converter.toDomain
import io.rienel.cw6.data.dto.StuffDto
import io.rienel.cw6.data.model.Stuff
import io.rienel.cw6.repository.StuffRepository
import io.rienel.cw6.ui.util.ResponseResult
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.Response
import timber.log.Timber
import javax.inject.Inject
import kotlin.streams.toList

@HiltViewModel
class StuffListViewModel @Inject constructor(
	private val stuffRepository: StuffRepository
) : ViewModel() {

	val stuffList: LiveData<List<Stuff>> = stuffRepository
		.stuffs.asLiveData()

	val responseResult: MutableLiveData<ResponseResult> by lazy {
		MutableLiveData<ResponseResult>()
	}

	fun getStuffs() {
		viewModelScope.launch {
			Timber.i("Sending request for stuff")
			val response: Response<List<StuffDto>>
			try {
				response = stuffRepository.getStuffs()
			} catch (e: Exception) {
				Timber.e(e, "Cannot obtain stuff list")
				val errnoException = e.cause?.cause as ErrnoException?
				responseResult.value = when (errnoException?.errno) {
					OsConstants.EHOSTUNREACH -> ResponseResult.HOST_IS_UNREACHABLE
					OsConstants.ECONNREFUSED -> ResponseResult.CONNECTION_REFUSED
					else -> ResponseResult.UNKNOWN
				}
				return@launch
			}
			val clients = response.body()
			if (clients == null) {
				Timber.i("Stuff DTO: empty response")
				responseResult.value = ResponseResult.EMPTY_RESPONSE
				return@launch
			}
			Timber.i("Received client $clients")
			responseResult.value = ResponseResult.OK
			withContext(Dispatchers.IO) {
				synchronized(stuffRepository) {
					stuffRepository.clear()
					stuffRepository.saveAllStuffs(
						clients
							.stream()
							.map(StuffDto::toDomain)
							.toList()
					)
				}
			}
		}
	}
}