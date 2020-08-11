package fr.shodo.romannumerals.domain;

class IterativeRomanNumerals implements RomanNumerals {

    public String toRoman(PositiveInteger numericValue) {
        String result = "";
        for (RomanStep romanStep : RomanStep.values()) {
            result += romanStep.repeatSymbol(numericValue.euclideanDivide(romanStep.number));
            numericValue = numericValue.mod(romanStep.number);
        }
        return result;
    }

}
