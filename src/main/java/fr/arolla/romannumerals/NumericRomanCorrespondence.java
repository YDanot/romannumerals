package fr.arolla.romannumerals;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

class NumericRomanCorrespondence {

    private static Map<Integer, String> romanNumericCorrespondenceMap = buildRomanArabianCorrespondenceMap();

    private static LinkedHashMap<Integer, String> buildRomanArabianCorrespondenceMap() {
        LinkedHashMap<Integer, String> map = new LinkedHashMap<>();
        map.put(1000, "M");
        map.put(900, "CM");
        map.put(500, "D");
        map.put(400, "CD");
        map.put(100, "C");
        map.put(90, "XC");
        map.put(50, "L");
        map.put(40, "XL");
        map.put(10, "X");
        map.put(9, "IX");
        map.put(5, "V");
        map.put(4, "IV");
        map.put(1, "I");
        return map;
    }

    static String letterCorrespondingTo(Integer numeric) {
        return romanNumericCorrespondenceMap.get(numeric);
    }

    static Set<Integer> descOrderedNumericSteps() {
        return romanNumericCorrespondenceMap.keySet();
    }

    static Integer lastStep(){
        return 1;
    }

    static Integer beforeLastStep(){
        return 4;
    }


    static int nextStep(int step) {
        Iterator<Integer> iterator = descOrderedNumericSteps().iterator();
        while (iterator.hasNext()) {
            Integer value = iterator.next();
            if (value == step) {
                if (iterator.hasNext()) {
                    return iterator.next();
                }
                return value;
            }
        }
        throw new IllegalArgumentException("No step define for " + step);
    }

}
