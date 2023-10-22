package edu.project1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public final class HangmanConsoleGame {
    private final Session session;

    public HangmanConsoleGame() {
        session = new Session();
    }

    @SuppressWarnings("RegexpSinglelineJava")
    public void run() {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in, StandardCharsets.UTF_8));
        String userInput;

        while (!session.isEnd()) {
            System.out.print(
                    "Word: " + session.getWordMask()
                    + "\nGuess a word: "
            );

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

            String message = session.guess(guess).message();
            System.out.println(message + "\n");
        }
    }
}
