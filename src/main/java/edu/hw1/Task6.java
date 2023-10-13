package edu.hw1;

import edu.Task;
import java.util.ArrayList;
import java.util.Collections;

public final class Task6 extends Task {

    private static final int MIN_FOUR_DIGIT_NUM = 1000;
    private static final int MIN_FIVE_DIGIT_NUM = 10000;
    private static final int KAPREKAR_CONST = 6174;

    private Task6() {
    }

    public static int countK(int num) {
        if (num <= MIN_FOUR_DIGIT_NUM || num >= MIN_FIVE_DIGIT_NUM) {
            return -1;
        }
        if (num == KAPREKAR_CONST) {
            return 0;
        }

        int localNum = num;
        ArrayList<Integer> digits = new ArrayList<>();
        while (localNum != 0) {
            digits.add(localNum % DECIMAL_BASE);
            localNum /= DECIMAL_BASE;
        }
        Collections.sort(digits);

        int biggerNum = 0;
        int smallerNum = 0;
        int digitsAmount = digits.size();
        for (int i = 0; i < digitsAmount; i++) {
            biggerNum = biggerNum * DECIMAL_BASE + digits.get(digitsAmount - 1 - i);
            smallerNum = smallerNum * DECIMAL_BASE + digits.get(i);
        }
        return 1 + countK(biggerNum - smallerNum);
    }
}
