package fr.arolla.romannumerals;

class IterativeRomanNumerals implements RomanNumerals {

    public String toRoman(int numericValue) {
        String result = "";
        for (RomanStep romanStep : RomanStep.values()) {
            result += repeat(romanStep.letter(), numericValue / romanStep.numeric);
            numericValue = numericValue % romanStep.numeric;
        }
        return result;
    }

    private static String repeat(String letter, int numericValue) {
        String result = "";
        for (int i = 0; i < numericValue; i++) {
            result += letter;
        }
        return result;
    }

}