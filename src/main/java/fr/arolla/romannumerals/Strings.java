package fr.arolla.romannumerals;

import org.jetbrains.annotations.Contract;

class Strings {

    @Contract(pure = true)
    static String repeat(String letter, int times) {
        return new String(new char[times]).replace("\0", letter);
    }
}
