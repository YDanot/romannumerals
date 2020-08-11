package fr.shodo.romannumerals.utils;

public class PositiveInteger {

    public static final PositiveInteger ZERO = from(0);

    private final int value;

    public int value() {
        return value;
    }

    private PositiveInteger(int value) {
        if (value < 0) {
            throw new IllegalArgumentException("A positive number should be positive");
        }
        this.value = value;
    }

    public static PositiveInteger from(int value) {
        return new PositiveInteger(value);
    }

    public EuclideanDivision div(PositiveInteger divisor){
        return new EuclideanDivision(this, divisor);
    }

}
