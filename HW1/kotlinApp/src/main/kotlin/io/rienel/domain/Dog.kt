package io.rienel.domain

import io.rienel.domain.interfaces.Feedable
import io.rienel.domain.interfaces.Speekable

/**
 * todo armotozov
 *
 * @author Artem Motozov
 * @since 2022.09.19
 */
class Dog(
    name: String,
    weight: Double,
    fullHeight: Double,
    fullLength: Double,
    fullWidth: Double,
    val catEaten: MutableList<Cat>,
    var ownerName: String
) : Animal(
    name,
    weight,
    AnimalType.DOG,
    fullHeight,
    fullLength,
    fullWidth
), Feedable<Cat>, Speekable {

    override var name: String
        get() = super.name
        set(value) {
            assert(value.isNotEmpty())
            super.name = value
        }
    override var weight: Double
        get() = super.weight
        set(value) {
            assert(value in 3.0 .. 20.0)
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

    override fun eat(food: Cat): Boolean {
        return if (catEaten.size > 10) {
            println("DOG: ENOUGH")
            false
        } else {
            true
        }
    }

    override fun speak(): String {
        return "DOG: BARK"
    }
}