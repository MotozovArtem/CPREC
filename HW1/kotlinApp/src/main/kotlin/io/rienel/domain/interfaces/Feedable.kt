package io.rienel.domain.interfaces

import io.rienel.domain.Animal

/**
 * todo armotozov
 *
 * @author Artem Motozov
 * @since 2022.09.19
 */
interface Feedable<T : Animal> {
    fun eat(food: T): Boolean
}