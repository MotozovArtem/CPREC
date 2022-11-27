package io.rienel.cw6.data.dto

import com.fasterxml.jackson.annotation.JsonProperty
import java.time.LocalDate
import java.util.UUID

data class NewOfferParameters(
	@JsonProperty("client_id")
	val clientId: UUID? = null,
	@JsonProperty("stuff_id")
	val stuffId: UUID? = null,
	@JsonProperty("start_date")
	val startDate: LocalDate? = null,
	@JsonProperty("ending_date")
	val endingDate: LocalDate? = null,
)
