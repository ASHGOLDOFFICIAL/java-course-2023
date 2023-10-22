package edu.project1;

final class Main {
    private Main() {
    }

    public static void main(String[] args) {
        String[] dictionary = {"cat", "dog", "tinkoff"};
        HangmanConsoleGame game = new HangmanConsoleGame(new StringArrayToDictionary(dictionary));
        game.run();
    }
}
