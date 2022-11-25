package io.rienel.cw6.data.util

import androidx.room.TypeConverter
import java.time.Instant
import java.time.LocalDate
import java.time.ZoneOffset

class LocalDateConverter {

	@TypeConverter
	fun fromTimestamp(value: Long?): LocalDate? {
		return value?.let {
			Instant.ofEpochMilli(it).atZone(ZoneOffset.UTC).toLocalDate()
		}
	}

	@TypeConverter
	fun fromLocalDate(value: LocalDate?): Long? {
		return value?.atStartOfDay(ZoneOffset.UTC)?.toInstant()?.toEpochMilli()
	}
}