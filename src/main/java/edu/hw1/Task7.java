package edu.hw1;

import edu.Consts;

public final class Task7 extends Consts {
    private Task7() {
    }

    private static int countBinaryDigits(int n) {
        int localNum = n;
        int count = 0;
        while (localNum != 0) {
            localNum >>= 1;
            count++;
        }
        return count;
    }

    public static int rotateRight(int n, int shift) {
        final int binaryDigitsAmount = countBinaryDigits(n);
        final int unperiodicShift = shift % binaryDigitsAmount;
        /*
         *   1) Берём двоичную запись числа и отбрасываем кол-во бит с конца, равное кол-ву сдвигов.
         *   2) Берём двоичную запись числа и приписываем к ней нули так, чтобы их кол-во равнялось кол-ву бит в числе,
         *      полученном выше.
         *   3) Объединяем биты эти чисел.
         *   4) Создаём число, которое содержит ноль и столько единиц, сколько и бит в двоичной записи изначального
         *      числа.
         *   5) Конъюнкцией двух полученных чисел получаем такое, в котором сохраняется лишь n последних бит,
         *      где n - число бит в изначальном числе. То есть ею мы обнуляем все разряды, вышедшие за пределы
         *      кол-ва бит изначального числа.
         * */
        return ((n >> unperiodicShift)
                | (n << (binaryDigitsAmount - unperiodicShift)))
                & ((1 << binaryDigitsAmount) - 1);
    }

    public static int rotateLeft(int n, int shift) {
        final int binaryDigitsAmount = countBinaryDigits(n);
        final int unperiodicShift = shift % binaryDigitsAmount;
        /*
         *   1) Берём двоичную запись числа и приписываем к ней нули, кол-во которых равно кол-ву сдвигов.
         *   2) Берём двоичную запись числа и отбрасываем биты с конца так, чтобы в нём осталось кол-во бит, равное
         *      кол-ву сдвигов.
         *   3) Объединяем биты эти чисел.
         *   4) Создаём число, которое содержит ноль и столько единиц, сколько и бит в двоичной записи изначального
         *      числа.
         *   5) Конъюнкцией двух полученных чисел получаем такое, в котором сохраняется лишь n последних бит,
         *      где n - число бит в изначальном числе. То есть ею мы обнуляем все разряды, вышедшие за пределы
         *      кол-ва бит изначального числа.
         * */
        return ((n << unperiodicShift)
                | (n >> (binaryDigitsAmount - unperiodicShift)))
                & ((1 << binaryDigitsAmount) - 1);
    }
}
