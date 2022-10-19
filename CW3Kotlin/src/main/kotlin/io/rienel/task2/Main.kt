package io.rienel.task2

import io.rienel.task1.model.Client
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import java.nio.file.Files
import java.nio.file.Paths
import java.time.LocalDate
import java.util.*

fun main() {
    val builder = Client.Builder()
    println("Введите данные о клиенте")
    do {
        println("Введите Фамилию")
        val surname = readLine()
        if (surname?.isNotBlank() == true) {
            builder.surname = surname
            break
        }
    } while (true)
    do {
        println("Введите Имя")
        val name = readLine()
        if (name?.isNotBlank() == true) {
            builder.name = name
            break
        }
    } while (true)
    do {
        println("Введите Отчетство")
        val patronymic = readLine()
        if (patronymic?.isNotBlank() == true) {
            builder.patronymic = patronymic
            break
        }
    } while (true)
    println("Введите пол (М или Ж) - необязательно")
    val sex = readLine()
    if (sex?.isNotBlank() == true && (sex == "М" || sex == "Ж")) {
        builder.sex = sex == "Ж"
    }
    do {
        println("Введите дату рождения в формате гггг-ММ-дд")
        val birthDateStr = readLine()
        if (birthDateStr?.isNotBlank() == true) {
            val birthDate = LocalDate.parse(birthDateStr)
            builder.birthDate = birthDate
            break
        }
    } while (true)
    do {
        println("Введите ИНН")
        val inn = readLine()
        if (inn?.isNotBlank() == true && inn.length == 10) {
            builder.inn = inn
            break
        }
    } while (true)
    do {
        println("Введите серию номер паспорта")
        val passportSerial = readLine()
        if (passportSerial?.isNotBlank() == true && passportSerial.length == 11) {
            builder.passportSerial = passportSerial
            break
        }
    } while (true)
    println("Введите телефон")
    val phone = readLine()
    if (phone?.isNotBlank() == true) {
        builder.phone = phone
    }
    val client: Client = builder.apply {
        id = UUID.randomUUID()
    }.build()
    Files.newBufferedWriter(Paths.get("clients.json")).use {
        it.write(Json.encodeToString(client))
    }
}