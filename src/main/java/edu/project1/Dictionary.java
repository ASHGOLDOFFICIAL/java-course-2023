package edu.project1;

import java.util.concurrent.ThreadLocalRandom;

final class Dictionary {
    private static final String[] DICTIONARY = {"cat", "man", "apple", "appendix"};

    private Dictionary() {
    }

    public static String randomWord() {
        int wordIndex = ThreadLocalRandom.current().nextInt(DICTIONARY.length);
        return DICTIONARY[wordIndex];
    }
}
