package io.rienel.task1.model

import kotlinx.serialization.KSerializer
import kotlinx.serialization.Serializable
import kotlinx.serialization.descriptors.PrimitiveKind
import kotlinx.serialization.descriptors.PrimitiveSerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.*
import kotlin.properties.Delegates

object UUIDSerializer : KSerializer<UUID> {
    override val descriptor = PrimitiveSerialDescriptor("UUID", PrimitiveKind.STRING)

    override fun deserialize(decoder: Decoder): UUID {
        return UUID.fromString(decoder.decodeString())
    }

    override fun serialize(encoder: Encoder, value: UUID) {
        encoder.encodeString(value.toString())
    }
}

object LocalDateSerializer : KSerializer<LocalDate> {
    override val descriptor = PrimitiveSerialDescriptor("LocalDate", PrimitiveKind.STRING)

    override fun deserialize(decoder: Decoder): LocalDate {
        return LocalDate.parse(decoder.decodeString())
    }

    override fun serialize(encoder: Encoder, value: LocalDate) {
        encoder.encodeString(value.format(DateTimeFormatter.ISO_DATE))
    }
}

@Serializable
data class Client(
    @Serializable(with = UUIDSerializer::class)
    var id: UUID,
    var surname: String,
    var name: String,
    var patronymic: String,
    var sex: Boolean,
    @Serializable(with = LocalDateSerializer::class)
    var birthDate: LocalDate,
    var inn: String,
    var passportSerial: String,
    var phone: String
) {
    class Builder {
        lateinit var id: UUID
        lateinit var surname: String
        lateinit var name: String
        lateinit var patronymic: String
        var sex by Delegates.notNull<Boolean>()
        lateinit var birthDate: LocalDate
        lateinit var inn: String
        lateinit var passportSerial: String
        lateinit var phone: String

        fun build() = Client(id, surname, name, patronymic, sex, birthDate, inn, passportSerial, phone)
    }
}