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
public class Cat extends Animal<Mouse> {

    private final List<Mouse> mousesEaten;

    private Integer lifeCount;

    public Cat(final String name,
               final Double weight,
               final Double fullHeight,
               final Double fullLength,
               final Double fullWidth,
               final Integer lifeCount) {
        super(name, weight, AnimalType.CAT, fullHeight, fullLength, fullWidth);
        mousesEaten = new ArrayList<>();
        this.lifeCount = lifeCount;
    }

    public void dropFromTable(String item) {
        Objects.requireNonNull(item);

        System.out.println("CAT: IT'S TIME TO CRASH " + item + ".\n...\n...\nBAM... It's smacked");
    }

    public Integer getLifeCount() {
        return lifeCount;
    }

    public void setLifeCount(Integer lifeCount) {
        this.lifeCount = lifeCount;
    }

    public List<Mouse> getMousesEaten() {
        return mousesEaten;
    }

    @Override
    public void setName(String name) {
        Objects.requireNonNull(name);
        super.setName(name);
    }

    @Override
    public void setWeight(Double weight) {
        Objects.requireNonNull(weight);
        if (weight < 2.0 || weight > 10.0) {
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
    public Boolean eat(Mouse food) {
        Objects.requireNonNull(food);

        mousesEaten.add(food);
        return true;
    }

    @Override
    public String speak() {
        return "CAT: MEOW";
    }
}
