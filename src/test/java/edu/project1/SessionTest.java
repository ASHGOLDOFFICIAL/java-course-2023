package edu.project1;

import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public final class SessionTest {
    private static class IllegalWordDict implements Dictionary {
        @Override
        public @NotNull String randomWord() {
            return "Ma";
        }
    }
    @Test
    @DisplayName("Слово некорректной длины")
    void illegalWord() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Session(new IllegalWordDict());
        });
    }
}
