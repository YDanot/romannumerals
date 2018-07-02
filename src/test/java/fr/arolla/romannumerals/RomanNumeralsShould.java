package fr.arolla.romannumerals;


import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(JUnitParamsRunner.class)
public class RomanNumeralsShould {

    private RomanNumerals romanNumerals = new RomanNumeralsWithMap();

    @Test
    @Parameters
    public void return_roman_with_numeric_value(int numericValue, String romanValue) {
        assertThat(toRoman(numericValue)).isEqualTo(romanValue);
    }

    private Object[] parametersForReturn_roman_with_numeric_value() {
        return new Object[][]{
                {1, "I"}, {2, "II"}, {3, "III"}, {4, "IV"}, {5, "V"},
                {6, "VI"}, {9, "IX"}, {10, "X"}, {40, "XL"}, {50, "L"},
                {90, "XC"}, {100, "C"}, {400, "CD"}, {500, "D"}, {900, "CM"},
                {1000, "M"}, {4999, "MMMMCMXCIX"}, {2018, "MMXVIII"}};
    }

    private String toRoman(int numericValue) {
        return romanNumerals.toRoman(numericValue);
    }
}
