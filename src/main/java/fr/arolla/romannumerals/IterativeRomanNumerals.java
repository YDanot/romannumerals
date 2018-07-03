package fr.arolla.romannumerals;

class IterativeRomanNumerals implements RomanNumerals {

    public String toRoman(int numericValue) {
        String result = "";
        for (RomanStep romanStep : RomanStep.values()) {
            result += Strings.repeat(romanStep.symbol(), numericValue / romanStep.number);
            numericValue = numericValue % romanStep.number;
        }
        return result;
    }

}