package edu.hw1;

import edu.Task;

import java.util.ArrayList;
import java.util.Collections;

public class Task6 extends Task {
    private Task6() {}

    public static int countK(int num) {
        if (num <= 1000 || num >= 10000) return -1;
        if (num == 6174) return 0;

        int localNum = num;
        ArrayList<Integer> digits = new ArrayList<>();
        while (localNum != 0) {
            digits.add(localNum % 10);
            localNum /= 10;
        }
        Collections.sort(digits);

        int biggerNum = 0;
        int smallerNum = 0;
        int digitsAmount = digits.size();
        for (int i = 0; i < digitsAmount; i++) {
            biggerNum = biggerNum*10 + digits.get(digitsAmount - 1 - i);
            smallerNum = smallerNum*10 + digits.get(i);
        }
        return 1 + countK(biggerNum - smallerNum);
    }
}
