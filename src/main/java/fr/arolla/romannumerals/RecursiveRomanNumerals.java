package fr.arolla.romannumerals;

class RecursiveRomanNumerals implements RomanNumerals {

    private static final int PENULTIMATE_NUMERIC_STEP = RomanStep.penultimate().numeric;
    private static final String LAST_LETTER = RomanStep.last().letter();

    @Override
    public String toRoman(int numericValue) {
        return toRoman(numericValue, RomanStep.M);
    }

    private String toRoman(int numericValue, RomanStep step) {
        if (numericValue < PENULTIMATE_NUMERIC_STEP){
            return repeat(LAST_LETTER, numericValue);
        }
        return repeat(step.letter(), numericValue / step.numeric)
                + toRoman(numericValue % step.numeric, step.next());
    }

    private static String repeat(String letter, int times) {
        String result = "";
        for (int i = 0; i < times; i++) {
            result += letter;
        }
        return result;
    }

}