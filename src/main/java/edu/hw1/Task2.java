package edu.hw1;

import edu.Consts;

public final class Task2 extends Consts {
    private Task2() {
    }

    public static int countDigits(long num) {
        int count = 0;
        long localNum = num;

        do {
            count++;
            localNum /= DECIMAL_BASE;
        } while (localNum != 0);

        return count;
    }
}
