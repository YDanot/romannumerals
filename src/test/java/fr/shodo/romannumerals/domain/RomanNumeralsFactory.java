package fr.shodo.romannumerals.domain;


import java.util.Arrays;
import java.util.List;

class RomanNumeralsFactory {

    static List<RomanNumerals> instances(){
        return Arrays.asList(new RecursiveRomanNumerals(), new IterativeRomanNumerals(), new DummyRomanNumerals());
    }
}
