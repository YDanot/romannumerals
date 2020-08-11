package fr.shodo.romannumerals.domain;

import fr.shodo.romannumerals.utils.EuclideanDivision;
import fr.shodo.romannumerals.utils.PositiveInteger;

class RecursiveRomanNumerals implements RomanNumerals {

    public String toRoman(PositiveInteger numericValue) {
        return toRoman(numericValue, RomanStep.M);
    }

    private String toRoman(PositiveInteger numericValue, RomanStep romanStep) {
        if (RomanStep.I.equals(romanStep)){
            return romanStep.repeatSymbol(numericValue);
        }
        final EuclideanDivision div = numericValue.div(romanStep.algebraic());
        return romanStep.repeatSymbol(div.quotient())
                + toRoman(div.remainder(), romanStep.lower());
    }

}
