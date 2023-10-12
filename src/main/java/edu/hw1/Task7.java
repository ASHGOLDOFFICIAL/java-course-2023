package edu.hw1;

import edu.Task;

public class Task7 extends Task {
    private Task7() {
    }

    private static int countBinaryDigits(int n) {
        int localNum = n;
        int count = 0;
        while (localNum != 0) {
            localNum = localNum >>> 1;
            count++;
        }
        return count;
    }

    private static int rotate(int n, int unperiodicShift, int binaryDigitsAmount) {
/*
        Создан только цикличсекий сдвиг вправо, потому что циклически сдвигать биты влево - это то же самое, что и
        сдвигать биты вправо (количество цифр в двоичной записи - непериодические сдвиги) раз.

        Так как, сдвигая биты столько раз, сколько и цифр в числе, мы получаем изначальное число, то будем использовать
        непериодическое кол-во сдвигов, то есть кол-во сдвигов, из которых вычтем все полные обороты. Очевидно, что
        таких сдвигов всегда меньше, чем цифр в двоичной записи числа.
*/

        int localNum = n;

//        Отбрасываем столько цифр в конце числа, сколько нужно сделать сдвигов (т.е от 1 до всех - 1).
        int shiftedNum = n >>> unperiodicShift;

        for (int i = unperiodicShift; i > 0; i--) {
/*
            Берём последнюю цифру из двоичной записи входного числа и смещаем её на (кол-во цифр - текущий сдвиг),
            т.о. каждая новая цифра сдвигается на одну позицию дальше, тем самым повторяется принцип работы
            циклического сдвига.

            После этого последняя цифра двоичной записи откидывается. Таким образом, все цифры отброшенные до цикла
            будут перемещены в начало двоичной записи числа.
*/
            shiftedNum += (localNum % 2) << (binaryDigitsAmount - i);
            localNum /= 2;
        }

//        LOGGER.info(Integer.toBinaryString(n));
//        LOGGER.info(Integer.toBinaryString(shiftedNum));

        return shiftedNum;
    }

/*
    Далее идут функции-обёртки над основной функцией, в которых меняется лишь количество непериодических сдвигов.

     - Для сдвигов вправо - просто число непериодических сдвигов.
     - Для сдвигов влево - число, обратное числу непериодических сдвигов. Обратным считается то число, которое в сумме
       с основным числом даёт количество цифр в двоичной записи. Исключением является ноль (потому что если число
       непериодических сдвигов равно 0, то сдвигать ничего не надо).
*/
    public static int rotateRight(int n, int shift) {
        final int binaryDigitsAmount = countBinaryDigits(n);
        final int unperiodicShift = shift % binaryDigitsAmount;
        return rotate(n, unperiodicShift, binaryDigitsAmount);
    }

    public static int rotateLeft(int n, int shift) {
        final int binaryDigitsAmount = countBinaryDigits(n);
        final int unperiodicShiftToRight = shift % binaryDigitsAmount;
        final int unperiodicShift = (unperiodicShiftToRight != 0) ? binaryDigitsAmount - unperiodicShiftToRight : 0;
        return rotate(n, unperiodicShift, binaryDigitsAmount);
    }
}
