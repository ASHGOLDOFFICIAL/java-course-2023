package edu.project1;

import java.util.ArrayList;

public final class Session {
    private static final int MAX_WRONG_GUESSES = 5;
    private final String guessedWord;
    private String wordMask;
    private final Character[] wordUniqueChars;
    private final ArrayList<Character> userAnswers;
    private int correctGuesses;
    private final int maxWrongGuesses;
    private int wrongGuesses;

    public Session(Dictionary dictionary) {
        this.guessedWord = dictionary.randomWord().toLowerCase();

        if (guessedWord.length() <= 2) {
            throw new IllegalArgumentException("Guessed word is less than 2 characters in length.");
        }

        this.wordMask = "*".repeat(guessedWord.length());
        this.wordUniqueChars = guessedWord.chars().distinct().mapToObj(c -> (char) c).toArray(Character[]::new);

        this.userAnswers = new ArrayList<>();
        this.correctGuesses = 0;

        this.maxWrongGuesses = MAX_WRONG_GUESSES;
        this.wrongGuesses = 0;
    }

    public Session(String[] dictionary) {
        this(new StringArrayToDictionary(dictionary));
    }

    public GuessResult guess(char guess) {
        if (userAnswers.contains(guess)) {
            return new GuessResult.AlreadyGuessed();
        }

        userAnswers.add(guess);
        if (guessedWord.indexOf(guess) == -1) {
            wrongGuesses++;
            return (wrongGuesses == maxWrongGuesses)
                    ? new GuessResult.Defeat()
                    : new GuessResult.FailedGuess(wrongGuesses, maxWrongGuesses);
        } else {
            correctGuesses++;
            this.wordMask = updateWordMask(guess);
            return (correctGuesses == wordUniqueChars.length)
                    ? new GuessResult.Win()
                    : new GuessResult.SuccessfulGuess();
        }
    }

    private String updateWordMask(char guess) {
        StringBuilder newMask = new StringBuilder(wordMask);

        int charIndex = guessedWord.indexOf(guess);
        while (charIndex >= 0) {
            newMask.setCharAt(charIndex, guess);
            charIndex = guessedWord.indexOf(guess, charIndex + 1);
        }

        return newMask.toString();
    }

    public boolean isEnd() {
        return (wrongGuesses == maxWrongGuesses) || (correctGuesses == wordUniqueChars.length);
    }

    public String getWord() {
        return this.guessedWord;
    }

    public String getWordMask() {
        return this.wordMask;
    }
}
