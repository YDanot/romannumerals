package fr.shodo.romannumerals.domain;

import fr.shodo.romannumerals.utils.EuclideanDivision;
import fr.shodo.romannumerals.utils.PositiveInteger;

class IterativeRomanNumerals implements RomanNumerals {

    public String toRoman(PositiveInteger numericValue) {
        StringBuilder result = new StringBuilder();

        for (RomanStep romanStep : RomanStep.values()) {
            final EuclideanDivision div = numericValue.div(romanStep.algebraic());
            result.append(romanStep.repeatSymbol(div.quotient()));
            numericValue = div.remainder();
        }

        return result.toString();
    }

}
