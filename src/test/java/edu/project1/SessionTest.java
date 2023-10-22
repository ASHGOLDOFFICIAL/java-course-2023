package edu.project1;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public final class SessionTest {
    private static final Logger LOGGER = LogManager.getLogger();
    private static class IllegalWordDict implements Dictionary {
        @Override
        public @NotNull String randomWord() {
            return "Ma";
        }
    }

    private static class NormalWordDict implements Dictionary {
        @Override
        public @NotNull String randomWord() {
            return "Normal";
        }
    }
    @Test
    @DisplayName("Слово некорректной длины")
    void illegalWord() {
        assertThrows(IllegalArgumentException.class, () -> new Session(new IllegalWordDict()));
    }

    @Test
    @DisplayName("Повторный ввод символа")
    void repeatedInput() {
        Session session = new Session(new NormalWordDict());

        session.guess('o');
        Session.State state = session.getState();
        LOGGER.info(state);

        session.guess('o');
        Session.State newState = session.getState();
        LOGGER.info(newState);

        assertThat(newState).isEqualTo(state);
    }

    @Test
    @DisplayName("Ошибочная догадка")
    void wrongGuess() {
        Session session = new Session(new NormalWordDict());
        Session.State state = session.getState();
        LOGGER.info(state);

        session.guess('q');
        Session.State newState = session.getState();
        LOGGER.info(newState);

        assertThat(newState.wordMask()).isEqualTo(state.wordMask());
        assertThat(newState.correctGuesses()).isEqualTo(state.correctGuesses());
        assertThat(newState.wrongGuesses()).isEqualTo(state.wrongGuesses() + 1);
    }
}
