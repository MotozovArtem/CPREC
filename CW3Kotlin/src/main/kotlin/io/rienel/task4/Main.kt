package io.rienel.task4

import java.io.BufferedReader
import java.io.FileReader
import java.nio.charset.StandardCharsets
import java.time.LocalDate
import java.time.Month
import java.util.*

data class Stuff(
    var id: UUID,
    var surname: String,
    var name: String,
    var patronymic: String,
    var sex: Boolean,
    var birthDate: LocalDate,
    var salary: Double
)

private const val ID_COLUMN_INDEX = 0
private const val SURNAME_COLUMN_INDEX = 1
private const val NAME_COLUMN_INDEX = 2
private const val PATRONYMIC_COLUMN_INDEX = 3
private const val SEX_COLUMN_INDEX = 4
private const val BIRTH_DATE_COLUMN_INDEX = 5
private const val SALARY_COLUMN_INDEX = 6

fun readDataFromFile(fileName: String): MutableList<Stuff> {
    val stuffList: MutableList<Stuff> = mutableListOf()
    val reader = BufferedReader(FileReader(fileName, StandardCharsets.UTF_8))
    reader.use {
        val header = reader.readLine()
        val columns = header.split(",".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()
        var readedLine = reader.readLine()
        while (readedLine != null) {
            val csvRow = readedLine.split(",".toRegex()).dropLastWhile { it.isEmpty() }
            if (csvRow.size < 7) {
                readedLine = reader.readLine()
                continue
            }
            val stuff = Stuff(
                id = UUID.fromString(csvRow[ID_COLUMN_INDEX]),
                surname = csvRow[SURNAME_COLUMN_INDEX],
                name = csvRow[NAME_COLUMN_INDEX],
                patronymic = csvRow[PATRONYMIC_COLUMN_INDEX],
                sex = csvRow[SEX_COLUMN_INDEX].toBoolean(),
                birthDate = LocalDate.parse(csvRow[BIRTH_DATE_COLUMN_INDEX]),
                salary = csvRow[SALARY_COLUMN_INDEX].toDouble(),
            )
            stuffList.add(stuff)
            readedLine = reader.readLine()
        }
    }
    return stuffList
}

fun main() {
    val stuffList: List<Stuff> = readDataFromFile("Stuff.csv")
    val ivansCount = stuffList.stream()
        .map { it.name } // .map(Stuff::getName)
        .filter { it == "Иван" }
        .count()
    println("Иванов в компании: $ivansCount")

    val femaleCount = stuffList.stream()
        .map { it.sex }
        .filter { it }
        .count()
    println("Женщин в компании: $femaleCount")

    val maleCount = stuffList.stream()
        .map { it.sex }
        .filter { !it }
        .count()
    println("Мужчин в компании: $maleCount")

    val septembersBirths = stuffList.stream()
        .map { it.birthDate.month }
        .filter { it == Month.SEPTEMBER }
        .count()
    println("Родилось в сентябре: $septembersBirths")

    val salaryLessThan40000 = stuffList.stream()
        .map { it.salary }
        .filter { it < 40000 }
        .count()
    println("Зарплата <40000: $salaryLessThan40000")

    val salaryGreaterThan40000LessThan80000 = stuffList.stream()
        .map { it.salary }
        .filter { it in 40000.0..80000.0 }
        .count()
    println("Зарплата [40000,80000]: $salaryGreaterThan40000LessThan80000")

    val salaryGreatThan80000 = stuffList.stream()
        .map { it.salary }
        .filter { it > 80000 }
        .count()
    println("Зарплата >80000: $salaryGreatThan80000")

}