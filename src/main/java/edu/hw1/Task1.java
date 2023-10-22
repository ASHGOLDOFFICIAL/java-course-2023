package edu.hw1;

import edu.Consts;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class Task1 extends Consts {
    private Task1() {
    }

    public static int minutesToSeconds(String str) {
//        Паттерн с допускание строки вида "00:00"
        final String regex = "^(?!0+:00)\\d{2,}:[0-5]\\d$";
        final Pattern pattern = Pattern.compile(regex);
        final Matcher matcher = pattern.matcher(str);

        if (!matcher.matches()) {
            return -1;
        }
        final String[] value = str.split(":");
        final int minutes = Integer.parseInt(value[0]) * 60;
        final int seconds = Integer.parseInt(value[1]);
        return minutes + seconds;
    }
}
