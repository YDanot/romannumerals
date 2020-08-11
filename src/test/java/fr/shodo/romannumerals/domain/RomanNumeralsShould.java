package fr.shodo.romannumerals.domain;


import fr.shodo.romannumerals.utils.PositiveInteger;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class RomanNumeralsShould {

    @ParameterizedTest
    @CsvSource({"1,I", "2,II", "3,III", "4,IV", "5,V", "6,VI", "9,IX", "10,X", "40,XL", "50,L",
            "90,XC", "100,C", "400,CD", "500,D", "900,CM", "1000,M", "3999,MMMCMXCIX", "2018,MMXVIII"})
    void convert(Integer numeric, String expected) {
      for (final RomanNumerals romanNumerals : RomanNumeralsFactory.instances()) {
        assertThat(romanNumerals.toRoman(PositiveInteger.from(numeric))).isEqualTo(expected);
      }
    }

}
