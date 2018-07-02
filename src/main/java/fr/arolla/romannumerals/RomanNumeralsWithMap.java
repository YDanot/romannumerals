package fr.arolla.romannumerals;

import java.util.LinkedHashMap;
import java.util.Map;

class RomanNumeralsWithMap implements RomanNumerals {

    private static Map<Integer, String> romanNumericCorrespondanceMap = buildRomanArabianCorrespondanceMap();

    private static LinkedHashMap<Integer, String> buildRomanArabianCorrespondanceMap() {
        LinkedHashMap<Integer, String> map = new LinkedHashMap<>();
        map.put(1000, "M"); map.put(900, "CM"); map.put(500, "D"); map.put(400, "CD");
        map.put(100, "C"); map.put(90, "XC"); map.put(50, "L"); map.put(40, "XL");
        map.put(10, "X"); map.put(9, "IX"); map.put(5, "V"); map.put(4, "IV"); map.put(1, "I");
        return map;
    }

    public String toRoman(int numericValue) {
        String result = "";
        for (Integer romanStep : romanNumericCorrespondanceMap.keySet()) {
            result += repeat(romanNumericCorrespondanceMap.get(romanStep), numericValue / romanStep);
            numericValue = numericValue % romanStep;
        }
        return result;
    }

    private static String repeat(String letter, int numericValue) {
        String result = "";
        for (int i = 0; i < numericValue; i++) {
            result += letter;
        }
        return result;
    }

}