package io.rienel.cw6.ui.data.office

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import io.rienel.cw6.data.converter.toDomain
import io.rienel.cw6.data.dto.OfficeDto
import io.rienel.cw6.data.model.Office
import io.rienel.cw6.repository.OfficeRepository
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

	fun getOffices() {
		viewModelScope.launch {
			Timber.i("Sending request for office")
			val response: Response<List<OfficeDto>>
			try {
				response = officeRepository.getOffices()
			} catch (e: Exception) {
				Timber.e(e, "Cannot obtain office list")
				return@launch
			}
			val offices = response.body()
			if (offices == null) {
				Timber.i("Office DTO: empty response")
				return@launch
			}
			Timber.i("Received offices $offices")
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