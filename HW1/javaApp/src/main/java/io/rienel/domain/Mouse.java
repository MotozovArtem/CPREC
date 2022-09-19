package io.rienel.domain;

import java.util.Objects;

/**
 * todo armotozov
 *
 * @author Artem Motozov
 * @since 2022.09.19
 */
public class Mouse extends Animal {

    private Double tailLength;

    public Mouse(final String name,
                 final Double weight,
                 final Double fullHeight,
                 final Double fullLength,
                 final Double fullWidth,
                 final Double tailLength) {
        super(name, weight, AnimalType.MOUSE, fullHeight, fullLength, fullWidth);
        this.tailLength = tailLength;
    }

    @Override
    public void setName(String name) {
        Objects.requireNonNull(name);
        super.setName(name);
    }

    @Override
    public void setWeight(Double weight) {
        Objects.requireNonNull(weight);
        if (weight < 0.5 || weight > 1.0) {
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
    public Boolean eat(Animal food) {
        Objects.requireNonNull(food);

        return tailLength <= 10;
    }

    @Override
    public String speak() {
        return "MOUSE: SQUEAK";
    }
}
