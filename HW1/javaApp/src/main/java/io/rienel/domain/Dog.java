package io.rienel.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * todo armotozov
 *
 * @author Artem Motozov
 * @since 2022.09.19
 */
public class Dog extends Animal<Cat>{

    private final List<Cat> catEaten;

    private String ownerName;

    public Dog(final String name,
               final Double weight,
               final Double fullHeight,
               final Double fullLength,
               final Double fullWidth,
               final String ownerName) {
        super(name, weight, AnimalType.DOG, fullHeight, fullLength, fullWidth);
        catEaten = new ArrayList<>();
        this.ownerName = ownerName;
    }

    public List<Cat> getCatEaten() {
        return catEaten;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    @Override
    public void setName(String name) {
        Objects.requireNonNull(name);
        super.setName(name);
    }

    @Override
    public void setWeight(Double weight) {
        Objects.requireNonNull(weight);
        if (weight < 2.0 || weight > 15.0) {
            throw new IllegalArgumentException("Illegal weight");
        }
        super.setWeight(weight);
    }

    @Override
    public void setFullHeight(Double fullHeight) {
        Objects.requireNonNull(fullHeight);
        if (fullHeight < 2.0 || fullHeight > 10.0) {
            throw new IllegalArgumentException("Illegal fullHeight");
        }
        super.setFullHeight(fullHeight);
    }

    @Override
    public void setFullLength(Double fullLength) {
        Objects.requireNonNull(fullLength);
        if (fullLength < 2.0 || fullLength > 10.0) {
            throw new IllegalArgumentException("Illegal fullLength");
        }
        super.setFullLength(fullLength);
    }

    @Override
    public void setFullWidth(Double fullWidth) {
        Objects.requireNonNull(fullWidth);
        if (fullWidth < 2.0 || fullWidth > 10.0) {
            throw new IllegalArgumentException("Illegal fullWidth");
        }
        super.setFullWidth(fullWidth);
    }

    @Override
    public Boolean eat(Cat food) {
        Objects.requireNonNull(food);

        if (catEaten.size() > 10) {
            System.out.println("DOG: ENOUGH");
            return false;
        }
        catEaten.add(food);
        return true;
    }

    @Override
    public String speak() {
        return "DOG: BARK";
    }
}
