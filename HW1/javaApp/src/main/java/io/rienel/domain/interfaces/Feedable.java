package io.rienel.domain.interfaces;

import io.rienel.domain.Animal;

/**
 * todo armotozov
 *
 * @author Artem Motozov
 * @since 2022.09.19
 */
public interface Feedable<T extends Animal> {
    Boolean eat(T food);
}
