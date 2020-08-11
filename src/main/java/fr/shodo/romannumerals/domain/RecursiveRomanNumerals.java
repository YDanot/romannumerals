package fr.shodo.romannumerals.domain;

class RecursiveRomanNumerals implements RomanNumerals {

    public String toRoman(PositiveInteger numericValue) {
        return toRoman(numericValue, RomanStep.M);
    }

    private String toRoman(PositiveInteger numericValue, RomanStep romanStep) {
        if (RomanStep.I.equals(romanStep)){
            return romanStep.repeatSymbol(numericValue);
        }

        return romanStep.repeatSymbol(numericValue.euclideanDivide(romanStep.number))
                + toRoman(numericValue.mod(romanStep.number), romanStep.lower());
    }

}
