package fr.shodo.romannumerals.domain;

import fr.shodo.romannumerals.utils.PositiveInteger;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static fr.shodo.romannumerals.domain.RomanStep.I;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class RomanStepTest {

  @ParameterizedTest
  @CsvSource({
          "M, CM",
          "CM, D",
          "D, CD",
          "CD, C",
          "C, XC",
          "XC, L",
          "L, XL",
          "XL, X",
          "X, IX",
          "IX, V",
          "V, IV",
          "IV, I"})
  void should_return_lower_step(RomanStep romanStep, RomanStep lowerStep) {
    assertThat(romanStep.lower()).isEqualTo(lowerStep);
  }

  @Test
  public void I_does_not_have_lower_step() {
    assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(I::lower);
  }

  @Test
  public void should_repeat_symbol_times() {
    Assertions.assertThat(I.repeatSymbol(PositiveInteger.ZERO)).isEqualTo("");
    Assertions.assertThat(I.repeatSymbol(PositiveInteger.from(10))).isEqualTo("IIIIIIIIII");
  }

}
