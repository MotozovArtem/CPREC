package io.rienel.cw6.api

import io.rienel.cw6.data.dto.NewOfferParameters
import io.rienel.cw6.data.dto.OfferStatistic
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
	suspend fun signNewOffer(@Body newOfferParams: NewOfferParameters): Response<Offer>

	@GET("/api/v1/offer/statistic")
	suspend fun getOfferStatistic(): Response<OfferStatistic>

	@GET("/api/v1/client")
	suspend fun getAllClients(): Response<List<Client>>

	@GET("/api/v1/client/{id}")
	suspend fun getClientById(@Path("id") id: String): Response<Client>

	@GET("/api/v1/offer")
	suspend fun getAllOffers(): Response<List<Offer>>

	@GET("/api/v1/offer/{id}")
	suspend fun getOfferById(@Path("id") id: String): Response<Offer>

	@GET("/api/v1/office")
	suspend fun getAllOffices(): Response<List<Office>>

	@GET("/api/v1/office/{id}")
	suspend fun getOfficeById(@Path("id") id: String): Response<Office>

	@GET("/api/v1/stuff")
	suspend fun getAllStuffs(): Response<List<Stuff>>

	@GET("/api/v1/stuff/{id}")
	suspend fun getStuffById(@Path("id") id: String): Response<Stuff>

	@GET("/api/v1/position")
	suspend fun getAllPositions(): Response<List<Position>>

	@GET("/api/v1/position/{id}")
	suspend fun getPositionById(@Path("id") id: String): Response<Position>
}