package fr.arolla.romannumerals;

import static fr.arolla.romannumerals.NumericRomanCorrespondence.*;

class RomanNumeralsRecursive implements RomanNumerals {

    @Override
    public String toRoman(int numericValue) {
        return toRoman(numericValue, 1000);
    }

    private String toRoman(int numericValue, int step) {
        if (numericValue < beforeLastStep()){
            return repeat(letterCorrespondingTo(lastStep()), numericValue);
        }
        return repeat(letterCorrespondingTo(step), numericValue / step) + toRoman(numericValue % step, NumericRomanCorrespondence.nextStep(step));
    }

    private static String repeat(String letter, int times) {
        String result = "";
        for (int i = 0; i < times; i++) {
            result += letter;
        }
        return result;
    }

}