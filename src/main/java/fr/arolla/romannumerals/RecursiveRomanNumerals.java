package fr.arolla.romannumerals;

class RecursiveRomanNumerals implements RomanNumerals {

    @Override
    public String toRoman(int numericValue) {
        return toRoman(numericValue, RomanStep.M);
    }

    private String toRoman(int numericValue, RomanStep step) {
        if (numericValue < RomanStep.secondSmallest().number){
            return Strings.repeat(RomanStep.smallest().symbol(), numericValue);
        }

        return Strings.repeat(step.symbol(), numericValue / step.number)
                + toRoman(numericValue % step.number, step.nextDescending());
    }

}