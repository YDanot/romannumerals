package fr.arolla.romannumerals.domain;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;

import static fr.arolla.romannumerals.domain.RomanStep.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

@RunWith(JUnitParamsRunner.class)
public class RomanStepTest {

    @Test
    @Parameters
    public void assert_that_lower_is(RomanStep romanStep, RomanStep lowerStep) {
        assertThat(romanStep.lower()).isEqualTo(lowerStep);
    }

    private Object[] parametersForAssert_that_lower_is() {
        return new Object[][]{
                {M, CM}, {CM, D}, {D, CD}, {CD, C}, {C, XC}, {XC, L},
                {L, XL}, {XL, X}, {X, IX}, {IX, V}, {V, IV},
                {IV, I}};
    }

    @Test
    public void I_does_not_have_lower_step(){
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(I::lower);
    }

    @Test
    public void should_repeat_symbol_times() throws Exception {
        Assertions.assertThat(I.repeatSymbol(PositiveInteger.ZERO)).isEqualTo("");
        Assertions.assertThat(I.repeatSymbol(PositiveInteger.from(10))).isEqualTo("IIIIIIIIII");
    }

}