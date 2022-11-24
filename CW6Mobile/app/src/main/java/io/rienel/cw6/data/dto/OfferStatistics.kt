package io.rienel.cw6.data.dto

data class OfferStatistic(
	val stuffStatistics: Map<String, Int>,
	val clientStatistics: Map<String, Int>,
	val clientSurnames: Set<String>
)