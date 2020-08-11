package fr.shodo.romannumerals.domain;


class PositiveInteger {

    static final PositiveInteger ZERO = from(0);

    final int value;

    private PositiveInteger(int value) {
        if (value < 0) {
            throw new IllegalArgumentException("A positive number should be positive");
        }
        this.value = value;
    }

    static PositiveInteger from(int value) {
        return new PositiveInteger(value);
    }

    PositiveInteger euclideanDivide(PositiveInteger dividend){
        return from(value / dividend.value);
    }

    PositiveInteger mod(PositiveInteger modulo){
        return from(value % modulo.value);
    }

}
