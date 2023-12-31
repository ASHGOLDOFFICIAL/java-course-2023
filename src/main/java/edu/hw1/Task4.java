package edu.hw1;

import edu.Task;

public final class Task4 extends Task {
    private Task4() {
    }

    public static String fixString(String str) {
        final StringBuilder fixedString = new StringBuilder();
        for (int i = 0; i < str.length() - str.length() % 2; i += 2) {
            fixedString.append(str.charAt(i + 1));
            fixedString.append(str.charAt(i));
        }
        if (str.length() % 2 == 1) {
            fixedString.append(str.charAt(str.length() - 1));
        }
        return fixedString.toString();
    }
}
