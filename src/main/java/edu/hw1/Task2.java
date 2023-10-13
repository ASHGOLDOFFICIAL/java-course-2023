package edu.hw1;

import edu.Task;

public final class Task2 extends Task {
    private Task2() {
    }

    public static int countDigits(long num) {
        int count = 0;
        long localNum = num;

        do {
            count++;
            localNum /= 10;
        } while (localNum != 0);

        return count;
    }
}
