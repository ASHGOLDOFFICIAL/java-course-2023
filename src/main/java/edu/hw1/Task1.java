package edu.hw1;

import java.util.regex.Pattern;
import java.util.regex.Matcher;

import edu.Task;

public final class Task1 extends Task {
    private Task1() {}

    public static long minutesToSeconds(String str) {
//        Паттерн с допускание строки вида "00:00"
        final String regex = "^(?!0+:00)\\d{2,}:[0-5]\\d$";
        final Pattern pattern = Pattern.compile(regex);
        final Matcher matcher = pattern.matcher(str);

        if (!matcher.matches()) {
            return -1;
        }
        final String[] value = str.split(":");
        final long minutes = Long.parseLong(value[0]) * 60;
        final int seconds = Integer.parseInt(value[1]);
        return minutes + seconds;
    }
}
