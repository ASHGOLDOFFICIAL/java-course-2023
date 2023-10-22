package edu.project1;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
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

    private static class ValidWordDict implements Dictionary {
        @Override
        public @NotNull String randomWord() {
            return "cat";
        }
    }
    @Test
    @DisplayName("Слово некорректной длины")
    void illegalWord() {
        assertThrows(IllegalArgumentException.class, () -> new Session(new IllegalWordDict()));
    }

    @Nested
    @DisplayName("Ввод раннее введённого символа")
    class RepeatedInput {
        private final Session session = new Session(new ValidWordDict());
        private final Session.State prevState;
        private final Session.State newState;
        private final char guess = 'a';

        {
            session.guess(guess);
            prevState = session.getState();

            session.guess(guess);
            newState = session.getState();

            LOGGER.info(prevState);
            LOGGER.info(newState);
        }

        @Test
        @DisplayName("Равенство масок")
        void checkWordMask() {
            assertThat(newState.wordMask()).isEqualTo(prevState.wordMask());
        }
        @Test
        @DisplayName("Равенство ответов игрока")
        void checkUserAnswers() {
            assertThat(newState.userAnswers()).containsExactly(prevState.userAnswers());
        }
        @Test
        @DisplayName("Равенство верных догадок")
        void checkCorrectGuesses() {
            assertThat(newState.correctGuesses()).isEqualTo(prevState.correctGuesses());
        }

        @Test
        @DisplayName("Равенство неверных догадок")
        void checkWrongGuesses() {
            assertThat(newState.wrongGuesses()).isEqualTo(prevState.wrongGuesses());
        }
    }

    @Nested
    @DisplayName("Верная догадка")
    class CorrectGuess {
        private final Session session = new Session(new ValidWordDict());
        private final Session.State prevState;
        private final Session.State newState;
        private final char guess = 'c';

        {
            prevState = session.getState();
            session.guess(guess);
            newState = session.getState();

            LOGGER.info(prevState);
            LOGGER.info(newState);
        }

        @Test
        @DisplayName("Неравенство масок")
        void checkWordMask() {
            assertThat(newState.wordMask()).isNotEqualTo(prevState.wordMask());
        }
        @Test
        @DisplayName("Проверка ответов игрока")
        void checkUserAnswers() {
            assertThat(prevState.userAnswers()).isEmpty();
            assertThat(newState.userAnswers()).containsExactly(guess);
        }
        @Test
        @DisplayName("Сравнение верных догадок")
        void checkCorrectGuesses() {
            assertThat(newState.correctGuesses()).isEqualTo(prevState.correctGuesses() + 1);
        }

        @Test
        @DisplayName("Равенство неверных догадок")
        void checkWrongGuesses() {
            assertThat(newState.wrongGuesses()).isEqualTo(prevState.wrongGuesses());
        }
    }

    @Nested
    @DisplayName("Ошибочная догадка")
    class WrongGuess {
        private final Session session = new Session(new ValidWordDict());
        private final Session.State prevState;
        private final Session.State newState;
        private final char guess = 'q';

        {
            prevState = session.getState();
            session.guess(guess);
            newState = session.getState();

            LOGGER.info(prevState);
            LOGGER.info(newState);
        }

        @Test
        @DisplayName("Равенство масок")
        void checkWordMask() {
            assertThat(newState.wordMask()).isEqualTo(prevState.wordMask());
        }
        @Test
        @DisplayName("Проверка ответов игрока")
        void checkUserAnswers() {
            assertThat(prevState.userAnswers()).isEmpty();
            assertThat(newState.userAnswers()).containsExactly(guess);
        }
        @Test
        @DisplayName("Равенство верных догадок")
        void checkCorrectGuesses() {
            assertThat(newState.correctGuesses()).isEqualTo(prevState.correctGuesses());
        }

        @Test
        @DisplayName("Сравнение неверных догадок")
        void checkWrongGuesses() {
            assertThat(newState.wrongGuesses()).isEqualTo(prevState.wrongGuesses() + 1);
        }
    }
}
