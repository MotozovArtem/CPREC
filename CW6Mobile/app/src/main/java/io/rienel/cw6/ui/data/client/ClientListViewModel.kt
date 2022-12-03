package io.rienel.cw6.ui.data.client

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import io.rienel.cw6.data.converter.toDomain
import io.rienel.cw6.data.dto.ClientDto
import io.rienel.cw6.data.model.Client
import io.rienel.cw6.repository.ClientRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.Response
import timber.log.Timber
import javax.inject.Inject
import kotlin.streams.toList

@HiltViewModel
class ClientListViewModel @Inject constructor(
	private val clientRepository: ClientRepository
) : ViewModel() {

	val clientsList: LiveData<List<Client>> = clientRepository
		.clients.asLiveData()

	fun getClients() {
		viewModelScope.launch {
			Timber.i("Sending request for client")
			val response: Response<List<ClientDto>>
			try {
				response = clientRepository.getClients()
			} catch (e: Exception) {
				Timber.e(e, "Cannot obtain clients list")
				return@launch
			}
			val clients = response.body()
			if (clients == null) {
				Timber.i("Clients DTO: empty response")
				return@launch
			}
			Timber.i("Received client $clients")
			withContext(Dispatchers.IO) {
				synchronized(clientRepository) {
					clientRepository.clear()
					clientRepository.saveAllClients(
						clients
							.stream()
							.map(ClientDto::toDomain)
							.toList()
					)
				}
			}
		}
	}
}