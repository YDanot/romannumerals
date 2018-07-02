package fr.arolla.romannumerals;

public class DummyRomanNumerals implements RomanNumerals {

    @Override
    public String toRoman(int numericValue) {
        return repeat("I", numericValue)
                .replaceAll("I{1000}", "M")
                .replaceAll("I{900}", "CM")
                .replaceAll("I{500}", "D")
                .replaceAll("I{400}", "CD")
                .replaceAll("I{100}", "C")
                .replaceAll("I{90}", "XC")
                .replaceAll("I{50}", "L")
                .replaceAll("I{40}", "XL")
                .replaceAll("I{10}", "X")
                .replaceAll("I{9}", "IX")
                .replaceAll("I{5}", "V")
                .replaceAll("I{4}", "IV");
    }

    private static String repeat(String letter, int numericValue) {
        String result = "";
        for (int i = 0; i < numericValue; i++) {
            result += letter;
        }

        return result;
    }
}