package io.rienel.domain;

import io.rienel.domain.interfaces.Feedable;
import io.rienel.domain.interfaces.Speekable;

/**
 * todo armotozov
 *
 * @author Artem Motozov
 * @since 2022.09.19
 */
public abstract class Animal<T extends Animal> implements Feedable<T>, Speekable {

    protected Animal(final String name,
                  final Double weight,
                  final AnimalType animalType,
                  final Double fullHeight,
                  final Double fullLength,
                  final Double fullWidth) {
        this.name = name;
        this.weight = weight;
        this.animalType = animalType;
        this.fullHeight = fullHeight;
        this.fullLength = fullLength;
        this.fullWidth = fullWidth;
    }

    private final AnimalType animalType;

    private String name;

    private Double weight;

    private Double fullHeight;

    private Double fullLength;

    private Double fullWidth;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public AnimalType getAnimalType() {
        return animalType;
    }

    public Double getFullHeight() {
        return fullHeight;
    }

    public void setFullHeight(Double fullHeight) {
        this.fullHeight = fullHeight;
    }

    public Double getFullLength() {
        return fullLength;
    }

    public void setFullLength(Double fullLength) {
        this.fullLength = fullLength;
    }

    public Double getFullWidth() {
        return fullWidth;
    }

    public void setFullWidth(Double fullWidth) {
        this.fullWidth = fullWidth;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "name='" + name + '\'' +
                ", weight=" + weight +
                ", animalType=" + animalType +
                ", fullHeight=" + fullHeight +
                ", fullLength=" + fullLength +
                ", fullWidth=" + fullWidth +
                '}';
    }
}
