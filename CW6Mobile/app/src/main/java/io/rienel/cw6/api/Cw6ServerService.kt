package io.rienel.cw6.api

import io.rienel.cw6.data.dto.ClientDto
import io.rienel.cw6.data.dto.NewOfferParameters
import io.rienel.cw6.data.dto.OfferDto
import io.rienel.cw6.data.dto.OfferStatistic
import io.rienel.cw6.data.dto.OfficeDto
import io.rienel.cw6.data.dto.PositionDto
import io.rienel.cw6.data.dto.StuffDto
import io.rienel.cw6.data.model.Client
import io.rienel.cw6.data.model.Offer
import io.rienel.cw6.data.model.Office
import io.rienel.cw6.data.model.Position
import io.rienel.cw6.data.model.Stuff
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path

interface Cw6ServerService {

	@PUT("/api/v1/offer")
	suspend fun signNewOffer(@Body newOfferParams: NewOfferParameters): Response<OfferDto>

	@GET("/api/v1/offer/statistic")
	suspend fun getOfferStatistic(): Response<OfferStatistic>

	@GET("/api/v1/client")
	suspend fun getAllClients(): Response<List<ClientDto>>

	@GET("/api/v1/client/{id}")
	suspend fun getClientById(@Path("id") id: String): Response<ClientDto>

	@GET("/api/v1/offer")
	suspend fun getAllOffers(): Response<List<OfferDto>>

	@GET("/api/v1/offer/{id}")
	suspend fun getOfferById(@Path("id") id: String): Response<OfferDto>

	@GET("/api/v1/office")
	suspend fun getAllOffices(): Response<List<OfficeDto>>

	@GET("/api/v1/office/{id}")
	suspend fun getOfficeById(@Path("id") id: String): Response<OfficeDto>

	@GET("/api/v1/stuff")
	suspend fun getAllStuffs(): Response<List<StuffDto>>

	@GET("/api/v1/stuff/{id}")
	suspend fun getStuffById(@Path("id") id: String): Response<StuffDto>

	@GET("/api/v1/position")
	suspend fun getAllPositions(): Response<List<PositionDto>>

	@GET("/api/v1/position/{id}")
	suspend fun getPositionById(@Path("id") id: String): Response<PositionDto>
}