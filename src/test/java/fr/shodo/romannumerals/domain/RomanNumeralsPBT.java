package fr.shodo.romannumerals.domain;

import com.pholser.junit.quickcheck.Property;
import com.pholser.junit.quickcheck.generator.InRange;
import com.pholser.junit.quickcheck.runner.JUnitQuickcheck;
import fr.shodo.romannumerals.utils.PositiveInteger;
import org.junit.runner.RunWith;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(JUnitQuickcheck.class)
public class RomanNumeralsPBT {

    @Property
    public void should_only_contains_IVXLDCM(@InRange(minInt = 1, maxInt = 4000) int numericValue) {
        for (final RomanNumerals romanNumerals : RomanNumeralsFactory.instances()) {
            assertThat(romanNumerals.toRoman(PositiveInteger.from(numericValue))).matches("[IVXLDCM]+");
        }
    }

    @Property
    public void should_never_contains_more_than_4_times_a_letter(@InRange(minInt = 1, maxInt = 3999) int numericValue) {
        for (final RomanNumerals romanNumerals : RomanNumeralsFactory.instances()) {
            String roman = romanNumerals.toRoman(PositiveInteger.from(numericValue));
            assertThat(occurenceOfLetter(roman, 'I')).isLessThanOrEqualTo(4);
            assertThat(occurenceOfLetter(roman, 'V')).isLessThanOrEqualTo(4);
            assertThat(occurenceOfLetter(roman, 'X')).isLessThanOrEqualTo(4);
            assertThat(occurenceOfLetter(roman, 'L')).isLessThanOrEqualTo(4);
            assertThat(occurenceOfLetter(roman, 'D')).isLessThanOrEqualTo(4);
            assertThat(occurenceOfLetter(roman, 'C')).isLessThanOrEqualTo(4);
            assertThat(occurenceOfLetter(roman, 'M')).isLessThanOrEqualTo(4);
        }
    }

    private long occurenceOfLetter(String s, char c) {
        return s.chars().filter(ch -> ch == c).count();
    }

}
