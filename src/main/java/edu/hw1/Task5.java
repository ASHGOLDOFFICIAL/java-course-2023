package edu.hw1;

import edu.Consts;

public final class Task5 extends Consts {
    private static final int MIN_PALINDROME = 11;

    private Task5() {
    }

    private static boolean isPalindrome(String str) {
        final int strLength = str.length();

        boolean isPalindrone = true;
        for (int i = 0; i < strLength / 2 + (strLength % 2); i++) {
            if (str.charAt(i) != str.charAt(strLength - 1 - i)) {
                isPalindrone = false;
                break;
            }
        }

        return isPalindrone;
    }

    public static boolean isPalindromeDescendant(int num) {
        if (num < MIN_PALINDROME) {
            return false;
        }

        String numString = String.valueOf(num);
        if (isPalindrome(numString)) {
            return true;
        }
        if (numString.length() % 2 == 1) {
            return false;
        }

        int localNum = num;
        int count = 0;
        int lastDigit = 0;
        int newNum = 0;
        int decimalShift = 1;

        while (localNum != 0) {
//            Берём последнюю цифру числа, затем "выкидываем" её.
            final int digit = localNum % DECIMAL_BASE;
            localNum /= DECIMAL_BASE;

/*
            Если итерация нечётная, т.е. каждая вторая (начинаем с 0), то суммируем текущую цифру и прошлую,
            "приписываем" справа к полученной сумме нули (decimalShift) и добавляем к этому числу предыдущее значение
            искомого числа. Затем увеличиваем decimalShift в 10 раз, если сумма текущей и прошлой цифр состоит из
            одной цифры, или в 100 раз, если их сумма состоит из двух цифр.

            Например, потомок числа 130177 будет получен следующим образом:
             - (7 + 7) * 1 + 0 = 14
               (т.к. 7+7=14 состоит из 2 цифр, то в следующей нечётной итерации произведём сдвиг на один ноль больше)
             - (0 + 1) * 100 + 14 = 114
             - (3 + 1) * 1000 + 114 = 4114
*/
            if (count % 2 == 1) {
                final int newDigit = lastDigit + digit;
                newNum = newDigit * decimalShift + newNum;
                decimalShift *= DECIMAL_BASE * ((newDigit / DECIMAL_BASE == 1) ? DECIMAL_BASE : 1);
            }

            count++;
            lastDigit = digit;
        }

        return isPalindromeDescendant(newNum);
    }
}
