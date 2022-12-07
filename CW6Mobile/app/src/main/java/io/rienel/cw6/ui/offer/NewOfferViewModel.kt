package io.rienel.cw6.ui.offer

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.liveData
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import io.rienel.cw6.data.converter.toDomain
import io.rienel.cw6.data.dto.ClientDto
import io.rienel.cw6.data.dto.NewOfferParameters
import io.rienel.cw6.data.dto.OfferDto
import io.rienel.cw6.data.dto.StuffDto
import io.rienel.cw6.data.model.Client
import io.rienel.cw6.data.model.Stuff
import io.rienel.cw6.repository.ClientRepository
import io.rienel.cw6.repository.OfferRepository
import io.rienel.cw6.repository.OfficeRepository
import io.rienel.cw6.repository.StuffRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.Response
import timber.log.Timber
import java.time.LocalDate
import java.util.UUID
import javax.inject.Inject
import kotlin.streams.toList

@HiltViewModel
class NewOfferViewModel @Inject constructor(
	private val offerRepository: OfferRepository,
	private val clientRepository: ClientRepository,
	private val officeRepository: OfficeRepository,
	private val stuffRepository: StuffRepository,
) : ViewModel() {
	private val _uiState = MutableStateFlow(NewOfferParameters())
	val newOfferParameters: StateFlow<NewOfferParameters> = _uiState.asStateFlow()

	val clients = clientRepository.clients.asLiveData()

	val stuffs = stuffRepository.stuffs.asLiveData()

	var selectedClient: Client? = null

	var selectedStuff: Stuff? = null

	fun saveNewOffer(startDate: LocalDate, endingDate: LocalDate): LiveData<OfferDto?> {
		return liveData {
			if (selectedClient == null) {
				emit(null)
				return@liveData
			}
			if (selectedStuff == null) {
				emit(null)
				return@liveData
			}
			val newOfferParameters = NewOfferParameters(
				UUID.fromString(selectedClient!!.clientId),
				UUID.fromString(selectedStuff!!.stuffId),
				startDate,
				endingDate
			)
			Timber.i("Sending request with new offer ${newOfferParameters}")
			val response: Response<OfferDto>
			try {
				response = offerRepository.saveNewOffer(newOfferParameters)
			} catch (e: Exception) {
				Timber.e(e, "Cannot save new offer")
				emit(null)
				return@liveData
			}
			val savedOffer = response.body()
			if (savedOffer == null) {
				Timber.i("New Offer: empty response")
			}
			emit(savedOffer)
		}
	}

	fun getAllForeignData() {
		getClients()
		getStuffs()
	}

	private fun getClients() {
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

	private fun getStuffs() {
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