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

    private RomanNumerals romanNumerals = new RomanNumeralsRecursive();

    @Property
    public void should_only_contains_IVXLDCM(@InRange(minInt = 1, maxInt = 1000000) int numericValue) {
        assertThat(romanNumerals.toRoman(numericValue)).matches("[IVXLDCM]+");
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
