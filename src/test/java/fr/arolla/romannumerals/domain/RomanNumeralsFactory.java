package fr.arolla.romannumerals.domain;


import fr.arolla.romannumerals.domain.RecursiveRomanNumerals;
import fr.arolla.romannumerals.domain.RomanNumerals;

class RomanNumeralsFactory {

    static RomanNumerals getInstance(){
        return new RecursiveRomanNumerals();
//        return new IterativeRomanNumerals();
//        return new DummyRomanNumerals();
    }
}
