package fr.arolla.romannumerals;

import static fr.arolla.romannumerals.NumericRomanCorrespondence.descOrderedNumericSteps;
import static fr.arolla.romannumerals.NumericRomanCorrespondence.letterCorrespondingTo;

class RomanNumeralsWithMap implements RomanNumerals {

    public String toRoman(int numericValue) {
        String result = "";
        for (Integer romanStep : descOrderedNumericSteps()) {
            result += repeat(letterCorrespondingTo(romanStep), numericValue / romanStep);
            numericValue = numericValue % romanStep;
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