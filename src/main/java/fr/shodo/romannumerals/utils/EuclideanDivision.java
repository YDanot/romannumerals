package fr.shodo.romannumerals.utils;

import static fr.shodo.romannumerals.utils.PositiveInteger.from;

public class EuclideanDivision {
  private final Integer quotient;
  private final Integer remainder;

  public EuclideanDivision(final PositiveInteger dividend, final PositiveInteger divisor) {
    this.quotient = dividend.value() / divisor.value();
    this.remainder = dividend.value() % divisor.value();
  }

  public PositiveInteger quotient() {
    return from(quotient);
  }

  public PositiveInteger remainder() {
    return from(remainder);
  }
}
