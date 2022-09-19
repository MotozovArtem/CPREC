package io.rienel.domain;

import java.util.Objects;

/**
 * todo armotozov
 *
 * @author Artem Motozov
 * @since 2022.09.19
 */
public class Panther extends Animal<Animal>{

    private final Boolean isBlack;

    public Panther(final String name,
                   final Double weight,
                   final Double fullHeight,
                   final Double fullLength,
                   final Double fullWidth) {
        super(name, weight, AnimalType.PANTHER, fullHeight, fullLength, fullWidth);
        isBlack = true;
    }

    public Panther(final String name,
                   final Double weight,
                   final Double fullHeight,
                   final Double fullLength,
                   final Double fullWidth,
                   final Boolean isBlack) {
        super(name, weight, AnimalType.PANTHER, fullHeight, fullLength, fullWidth);
        this.isBlack = isBlack;
    }

    public Boolean getBlack() {
        return isBlack;
    }

    @Override
    public void setName(String name) {
        Objects.requireNonNull(name);
        super.setName(name);
    }

    @Override
    public void setWeight(Double weight) {
        Objects.requireNonNull(weight);
        if (weight < 10.0 || weight > 50.0) {
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

        System.out.println("PANTHER: EAT ALL");
        return true;
    }

    @Override
    public String speak() {
        if (isBlack) {
            return "PANTHER: ВАКАНДА ФОРЕВЕР";
        } else {
            return "PANTHER: ROARMEOW";
        }
    }
}
