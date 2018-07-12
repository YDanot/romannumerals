package fr.arolla.romannumerals.domain;

import com.pholser.junit.quickcheck.Property;
import com.pholser.junit.quickcheck.generator.InRange;
import com.pholser.junit.quickcheck.runner.JUnitQuickcheck;
import org.hamcrest.CoreMatchers;
import org.junit.Assume;
import org.junit.runner.RunWith;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(JUnitQuickcheck.class)
public class RomanNumeralsPBT {

    private RomanNumerals romanNumerals = RomanNumeralsFactory.getInstance();

    @Property
    public void should_only_contains_IVXLDCM(@InRange(minInt = 1, maxInt = 1000000) int numericValue) {
        assertThat(romanNumerals.toRoman(PositiveInteger.from(numericValue))).matches("[IVXLDCM]+");
    }

    @Property
    public void should_never_contains_more_than_4_times_a_letter_except_M(@InRange(minInt = 1, maxInt = 10000) int numericValue) {
        String roman = romanNumerals.toRoman(PositiveInteger.from(numericValue));
        assertThat(occurenceOfLetter(roman,'I')).isLessThanOrEqualTo(4);
        assertThat(occurenceOfLetter(roman,'V')).isLessThanOrEqualTo(4);
        assertThat(occurenceOfLetter(roman,'X')).isLessThanOrEqualTo(4);
        assertThat(occurenceOfLetter(roman,'L')).isLessThanOrEqualTo(4);
        assertThat(occurenceOfLetter(roman,'D')).isLessThanOrEqualTo(4);
        assertThat(occurenceOfLetter(roman,'C')).isLessThanOrEqualTo(4);
    }

    @Property
    public void M_should_always_be_first_letter_when_number_greather_than_1000(@InRange(minInt = 1000, maxInt = 10000) int numericValue) {
        String roman = romanNumerals.toRoman(PositiveInteger.from(numericValue));
        Assume.assumeThat(roman, CoreMatchers.containsString("I"));
        Assume.assumeThat(roman, CoreMatchers.containsString("V"));
        Assume.assumeThat(roman, CoreMatchers.containsString("X"));
        Assume.assumeThat(roman, CoreMatchers.containsString("C"));
        Assume.assumeThat(roman, CoreMatchers.containsString("D"));
        Assume.assumeThat(roman, CoreMatchers.containsString("L"));
        assertThat(roman.indexOf('I')).isGreaterThan(roman.lastIndexOf('M'));
        assertThat(roman.indexOf('V')).isGreaterThan(roman.lastIndexOf('M'));
        assertThat(roman.indexOf('X')).isGreaterThan(roman.lastIndexOf('M'));
        assertThat(roman.indexOf('L')).isGreaterThan(roman.lastIndexOf('M'));
        assertThat(roman.indexOf('D')).isGreaterThan(roman.lastIndexOf('M'));
        assertThat(roman.indexOf('C')).isGreaterThan(roman.lastIndexOf('M'));
    }

    private long occurenceOfLetter(String s, char c) {
        return s.chars().filter(ch -> ch == c).count();
    }

}
