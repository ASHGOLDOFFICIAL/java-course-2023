package edu.project1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

@SuppressWarnings("RegexpSinglelineJava")
public final class HangmanConsoleGame {
    private final Session session;

    public HangmanConsoleGame(Dictionary dictionary) {
        session = new Session(dictionary);
    }

    public void run() {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in, StandardCharsets.UTF_8));
        String userInput;

        while (!session.isEnd()) {
            System.out.print("\nWord: " + session.getWordMask() + "\nGuess a word: ");

            try {
                userInput = in.readLine();
            } catch (IOException e) {
                continue;
            }

            if (userInput == null) {
                break;
            }

            char guess;
            if (userInput.length() != 1) {
                continue;
            } else {
                guess = userInput.toLowerCase().charAt(0);
            }

            printState(session.guess(guess));
        }
        System.out.println("\nThe word `" + session.getWord() + "` was guessed.");
    }

    private void printState(GuessResult guess) {
        System.out.println(guess.message());
    }
}
