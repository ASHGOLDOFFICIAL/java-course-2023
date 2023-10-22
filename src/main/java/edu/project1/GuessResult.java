package edu.project1;

import org.jetbrains.annotations.NotNull;

public interface GuessResult {
    @NotNull String message();

    record AlreadyGuessed() implements GuessResult {
        @Override
        public @NotNull String message() {
            return "You've already guessed this letter!";
        }
    }

    record Win() implements GuessResult {
        @Override
        public @NotNull String message() {
            return "You won!";
        }
    }

    record Defeat() implements GuessResult {
        @Override
        public @NotNull String message() {
            return "You lost!";
        }
    }

    record SuccessfulGuess() implements GuessResult {
        @Override
        public @NotNull String message() {
            return "Hit!";
        }
    }

    record FailedGuess(int wrongGuesses, int maxWrongGuesses) implements GuessResult {
        @Override
        public @NotNull String message() {
            final int mistakesLeft = maxWrongGuesses - wrongGuesses;
            return String.format(
                    "Missed, %d mistake%s left",
                    mistakesLeft,
                    (mistakesLeft > 1) ? "s" : ""
            );
        }
    }
}
