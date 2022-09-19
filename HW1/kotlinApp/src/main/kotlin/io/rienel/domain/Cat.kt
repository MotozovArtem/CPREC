package io.rienel.domain

import io.rienel.domain.interfaces.Feedable
import io.rienel.domain.interfaces.Speekable
import java.util.StringJoiner

/**
 * todo armotozov
 *
 * @author Artem Motozov
 * @since 2022.09.19
 */
class Cat(
    name: String,
    weight: Double,
    fullHeight: Double,
    fullLength: Double,
    fullWidth: Double,
    var lifeCount: Int,
    val mousesEaten: MutableList<Mouse>
) : Animal(
    name,
    weight,
    AnimalType.CAT,
    fullHeight,
    fullLength,
    fullWidth
), Feedable<Mouse>, Speekable {

    override var name: String
        get() = super.name
        set(value) {
            assert(value.isNotEmpty())
            super.name = value
        }
    override var weight: Double
        get() = super.weight
        set(value) {
            assert(value in 2.0 .. 10.0)
            super.weight = value
        }

    override var fullHeight: Double
        get() = super.fullHeight
        set(value) {
            assert(fullHeight in 50.0 .. 100.0)
            super.fullHeight = value
        }

    override var fullLength: Double
        get() = super.fullLength
        set(value) {
            assert(fullLength in 50.0 .. 100.0)
            super.fullLength = value
        }
    override var fullWidth: Double
        get() = super.fullWidth
        set(value) {
            assert(fullWidth in 50.0 .. 100.0)
            super.fullWidth = value
        }

    fun dropFromTable(item: String?) {
        println("CAT: IT'S TIME TO CRASH $item.\n...\n...\nBAM... It's smacked")
    }

    override fun eat(food: Mouse): Boolean {
        mousesEaten.add(food)
        return true
    }

    override fun speak(): String {
        val stringJoiner = StringJoiner(" ")
        for (i in 0 until lifeCount) {
            stringJoiner.add("MEOW")
        }
        return stringJoiner.toString()
    }
}