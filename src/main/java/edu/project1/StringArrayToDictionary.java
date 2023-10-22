package edu.project1;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;
import org.jetbrains.annotations.NotNull;

final class StringArrayToDictionary implements Dictionary {
    private final String[] dict;

    StringArrayToDictionary(String[] wordsArray) {
        String[] filteredWords = Arrays.stream(wordsArray).filter(s -> s.length() > 2).toArray(String[]::new);
        for (String word : wordsArray) {
            if (word.length() <= 2) {
                throw new IllegalArgumentException("All words must be of length greater than 2.");
            }
        }
        this.dict = wordsArray;
    }

    @Override
    public @NotNull String randomWord() {
        int wordIndex = ThreadLocalRandom.current().nextInt(dict.length);
        return dict[wordIndex];
    }
}
