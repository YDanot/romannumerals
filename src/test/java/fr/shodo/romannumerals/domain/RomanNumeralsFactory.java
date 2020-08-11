package fr.shodo.romannumerals.domain;


class RomanNumeralsFactory {

    static RomanNumerals getInstance(){
        return new RecursiveRomanNumerals();
//        return new IterativeRomanNumerals();
//        return new DummyRomanNumerals();
    }
}
