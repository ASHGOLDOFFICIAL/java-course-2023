package edu.hw1;

public class Task2 {
    private Task2() {}

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
