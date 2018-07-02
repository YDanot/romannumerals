package fr.arolla.romannumerals;

import com.pholser.junit.quickcheck.Property;
import com.pholser.junit.quickcheck.generator.InRange;
import com.pholser.junit.quickcheck.runner.JUnitQuickcheck;
import org.hamcrest.CoreMatchers;
import org.junit.Assume;
import org.junit.runner.RunWith;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(JUnitQuickcheck.class)
public class RomanNumeralsPBT {

    private RomanNumerals romanNumerals = new IterativeRomanNumerals();

    @Property
    public void should_only_contains_IVXLDCM(@InRange(minInt = 1, maxInt = 1000000) int numericValue) {
        assertThat(romanNumerals.toRoman(numericValue)).matches("[IVXLDCM]+");
    }

    @Property
    public void should_never_contains_more_than_3_times_a_letter_except_M(@InRange(minInt = 1, maxInt = 1000000) int numericValue) {
        String roman = romanNumerals.toRoman(numericValue);
        assertThat(roman).doesNotMatch("I{4,}?");
        assertThat(roman).doesNotMatch("V{4,}?");
        assertThat(roman).doesNotMatch("X{4,}?");
        assertThat(roman).doesNotMatch("L{4,}?");
        assertThat(roman).doesNotMatch("D{4,}?");
        assertThat(roman).doesNotMatch("C{4,}?");
    }

    @Property
    public void M_should_always_be_first_Letter(@InRange(minInt = 1000, maxInt = 1000000) int numericValue) {
        String roman = romanNumerals.toRoman(numericValue);
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

}
