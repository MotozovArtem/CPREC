package io.rienel.cw6.data.dto

import com.fasterxml.jackson.annotation.JsonProperty

data class OfferStatistic(
	@JsonProperty("stuff_statistics")
	val stuffStatistics: Map<String, Int>? = null,
	@JsonProperty("client_statistics")
	val clientStatistics: Map<String, Int>? = null,
	@JsonProperty("client_surnames")
	val clientSurnames: Set<String>? = null
)