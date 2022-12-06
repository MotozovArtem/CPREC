package io.rienel.cw6.ui.data.stuff

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import io.rienel.cw6.data.converter.toDomain
import io.rienel.cw6.data.dto.StuffDto
import io.rienel.cw6.data.model.Stuff
import io.rienel.cw6.repository.StuffRepository
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

	fun getStuffs() {
		viewModelScope.launch {
			Timber.i("Sending request for stuff")
			val response: Response<List<StuffDto>>
			try {
				response = stuffRepository.getStuffs()
			} catch (e: Exception) {
				Timber.e(e, "Cannot obtain stuff list")
				return@launch
			}
			val clients = response.body()
			if (clients == null) {
				Timber.i("Stuff DTO: empty response")
				return@launch
			}
			Timber.i("Received client $clients")
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