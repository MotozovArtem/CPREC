package io.rienel.cw6.ui.data.office

import android.system.ErrnoException
import android.system.OsConstants
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import io.rienel.cw6.data.converter.toDomain
import io.rienel.cw6.data.dto.OfficeDto
import io.rienel.cw6.data.model.Office
import io.rienel.cw6.repository.OfficeRepository
import io.rienel.cw6.ui.util.ResponseResult
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.Response
import timber.log.Timber
import javax.inject.Inject
import kotlin.streams.toList

@HiltViewModel
class OfficeListViewModel @Inject constructor(
	private val officeRepository: OfficeRepository
) : ViewModel() {

	val officesList: LiveData<List<Office>> = officeRepository
		.offices.asLiveData()

	val responseResult: MutableLiveData<ResponseResult> by lazy {
		MutableLiveData<ResponseResult>()
	}

	fun getOffices() {
		viewModelScope.launch {
			Timber.i("Sending request for office")
			val response: Response<List<OfficeDto>>
			try {
				response = officeRepository.getOffices()
			} catch (e: Exception) {
				Timber.e(e, "Cannot obtain office list")
				val errnoException = e.cause?.cause as ErrnoException?
				responseResult.value = when (errnoException?.errno) {
					OsConstants.EHOSTUNREACH -> ResponseResult.HOST_IS_UNREACHABLE
					OsConstants.ECONNREFUSED -> ResponseResult.CONNECTION_REFUSED
					else -> ResponseResult.UNKNOWN
				}
				return@launch
			}
			val offices = response.body()
			if (offices == null) {
				Timber.i("Office DTO: empty response")
				responseResult.value = ResponseResult.EMPTY_RESPONSE
				return@launch
			}
			Timber.i("Received offices $offices")
			responseResult.value = ResponseResult.OK
			withContext(Dispatchers.IO) {
				synchronized(officeRepository) {
					officeRepository.clear()
					officeRepository.saveAllOffices(
						offices
							.stream()
							.map(OfficeDto::toDomain)
							.toList()
					)
				}
			}
		}
	}
}