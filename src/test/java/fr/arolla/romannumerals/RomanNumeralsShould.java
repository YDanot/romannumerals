package fr.arolla.romannumerals;


import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(JUnitParamsRunner.class)
public class RomanNumeralsShould {

    private Object[] parametersForReturn_roman_with_numeric_value() {
        return new Object[][] {
                {1,"I"},
                {2,"II"},
                {3,"III"},
                {4,"IV"},
                {5,"V"},
                {6,"VI"},
                {9,"IX"},
                {10,"X"},
                {40,"XL"},
                {50,"L"},
                {90,"XC"},
                {100,"C"},
                {400,"CD"},
                {500,"D"},
                {900,"CM"},
                {1000,"M"},
                {1954,"MCMLIV"},
                {2018,"MMXVIII"},
        };
    }

    @Test
    @Parameters
    public void return_roman_with_numeric_value(int numericValue, String romanValue) {
        assertThat(toRoman(numericValue)).isEqualTo(romanValue);
    }

    private String toRoman(int numericValue) {
        return repeat("I", numericValue)
                .replaceAll("I{1000}","M")
                .replaceAll("I{900}","CM")
                .replaceAll("I{500}","D")
                .replaceAll("I{400}","CD")
                .replaceAll("I{100}","C")
                .replaceAll("I{90}","XC")
                .replaceAll("I{50}","L")
                .replaceAll("I{40}","XL")
                .replaceAll("I{10}","X")
                .replaceAll("I{9}","IX")
                .replaceAll("I{5}","V")
                .replaceAll("I{4}","IV");
    }

    private String repeat(String letter, int numericValue) {
        String result = "";
        for (int i = 0; i < numericValue; i++) {
            result += letter;
        }

        return result;
    }
}
