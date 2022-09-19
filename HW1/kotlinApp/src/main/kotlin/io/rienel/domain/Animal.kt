package io.rienel.domain

/**
 * todo armotozov
 *
 * @author Artem Motozov
 * @since 2022.09.19
 */
abstract class Animal(
    open var name: String,
    open var weight: Double,
    open val animalType: AnimalType,
    open var fullHeight: Double,
    open var fullLength: Double,
    open var fullWidth: Double,
) {
    override fun toString(): String {
        return "Animal{" +
                "name='" + name + '\'' +
                ", weight=" + weight +
                ", animalType=" + animalType +
                ", fullHeight=" + fullHeight +
                ", fullLength=" + fullLength +
                ", fullWidth=" + fullWidth +
                '}'
    }
}