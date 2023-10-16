package edu.hw1;

import edu.Task;

public final class Task8 extends Task {
    private static final int BOARD_SIZE = 8;
    private static final int TWELVE_BITS = 2048; // 10 \ 0000 0000 \ 00
    private static final int TWO_SQUARES_TO_SIDES = 17; // 10001 -> 10x01, где x - это конь (только рядом выше)
    private static final int ONE_SQUARE_TO_SIDES = 5; // 101 -> 1x1, где x - это конь (только двумя рядами выше)

    private Task8() {
    }

    public static boolean knightBoardCapture(int[][] board) {
        /*
         * Я решил попрактиковать побитовые операции, но в результате этого могла пострадать читабельность кода, поэтому
         * далее я буду пытаться объяснять, как данный код работает в комментариях.
         *
         * Общая идея такова: каждый ряд шахматной доски можно представить как целое число, такое, что единицы в его
         * двоичной записи будут обозначать наличие коня в клетке, а нули - его отсутствие. Таким образом, нам нужны
         * 8-битные числа (допускаются ведущие нули). Но фактически будем использовать 12-битные числа: по два
         * дополнительных бита с каждой стороны, так как конь может ходить на два столбца по сторонам. То есть, чтобы
         * не проверять, выходит ли конь за границы поля, мы просто расширим поле на два столбца в обе стороны.
         *
         * Заметим, что если некоторый конь может захватить другого, то это верно и в обратную сторону. Поэтому будем
         * рассматривать то, может ли некоторый конь захватить какого-нибудь коня ниже него. В таком случае будем
         * рассматривать лишь ходы коня вниз. Так как конь может ходить на два ряда вниз, расширим поле снизу на два
         * ряда.
         *
         * Дополнительные ряды снизу рассматривать не будет, а отбросим. Дополнительные биты по бокам влиять не будут,
         * так как они будут обнулены.
         * */

        if (board.length != BOARD_SIZE) {
            throw new RuntimeException("Array's length should be 8");
        }

        /*
         * int[10] canBeCapturedRows - набор таких чисел, в двоичной записи которых единица обозначает, что существует
         *   конь, способный захватить эту клетку, а ноль - что ни один конь эту клетку захватить не может. Так как
         *   мы расширили поле вниз на два ряда для ходов коня, то размер массива - 10, а не 8.
         * */
        int[] canBeCapturedRows = new int[BOARD_SIZE + 2];

        /*
         * Вместо того, что изнутри цикла возвращать true/false, введём на то отдельную переменную, которую вернём в
         * конце. Сделаем это для того, что проверить все строки на то, чтобы они не были null (должен кинуть
         * NullPointerException при попытке обращения, как я понял) и на то, чтобы длины массивов были равны 8.
         * */
        boolean noCaptures = true;

        for (int i = 0; i < BOARD_SIZE; i++) {
            int[] row = board[i];

            if (row.length != BOARD_SIZE) {
                throw new IllegalArgumentException("Nested arrays' length should be 8");
            }

            /*
             * currentRow - число, в двоичную запись которого будем добавлять единицы на места коней на поле.
             * capturesOneRowBelow - число, в двоичную запись которого будем добавлять единицы на места тех клеток,
             *   что конь может захватить на одном ряду ниже него.
             * capturesTwoRowsBelow - то же, что и выше, но для двух рядов ниже коня.
             * */
            int currentRow = 0;
            int capturesOneRowBelow = TWELVE_BITS;
            int capturesTwoRowsBelow = TWELVE_BITS;

            for (int j = 0; j < BOARD_SIZE; j++) {
                int square = row[j];

                /*
                 * Число 17 в двоичной записи - 10001. Нам нужно, что третий бит этого числа занял позицию нашего коня,
                 * таким образом мы нанесём ходы на один вниз и два в сторону.
                 *
                 * Например, вот часть поля:
                 *    10 \ 0 0 1 0 0 0 1 0 \ 00
                 *    10 \ x 0 0 0 x 0 0 0 \ x0
                 * (единичка - конь, а x - клетки рядом ниже, которые он может захватить, \ - граница между основным
                 *  полем и 2-битным расширением).
                 * */
                capturesOneRowBelow |= (TWO_SQUARES_TO_SIDES * square << j);

                /*
                 * Число 5 в двоичной записи - 101. Нам нужно, чтобы второй бит этого числа занял позицию нашего коня,
                 * таким образом мы нанесём ходы на два вниз и один в сторону.
                 *
                 * Например, вот часть поля:
                 *     10 \ 0 1 0 0 0 0 0 1 \ 00
                 *     10 \ 0 0 0 0 0 0 0 0 \ 00
                 *     10 \ x 0 x 0 0 0 x 0 \ x0
                 * */
                capturesTwoRowsBelow |= (ONE_SQUARE_TO_SIDES * square << (j + 1));
                currentRow |= (square << (j + 2));
            }


            /*
             * Проверяем, пересечение между текущим рядом и возможными захватами из canBeCapturedRows.
             *
             * Заметим, что currentRow - это максимум 10-битное число (11-й и 12-й равны нулю, так как максимальный
             * сдвиг одного бита был 9, т. е. до 10-го бита), первый и второй бит тоже равны нулю, так как производился
             * сдвиг на 2 минимум, то есть все дополнительные 4 бита равны нулю и при конъюнкции будут обнулять 1-й,
             * 2-й, 11-й, 12-й биты чисел из canBeCapturedRows. Следовательно, сравниваться будут фактические только
             * биты с 3-го по 9-й, то есть те, что соответствуют изначальному ряду.
             *
             * Таким образом, расширение поля не влияет на ответ.
             * */
            if ((currentRow & canBeCapturedRows[i]) != 0) {
                noCaptures = false;
            }

            /*
             * Вносим наш ряд в виде числа в массив рядов.
             *
             * Затем объединяем полученные "ряды захватов" с полученными ранее:
             *   Нулевой (ряд 1) элемент массива остаётся нулём, так как никто сверху захватить верхний ряд не может.
             *   Первый (ряд 2) элемент будет объединением возможных ходов из первого ряда на один вниз.
             *   Второй (ряд 3) - объединение возможных ходов из первого ряда на два вниз и из второго на один вниз.
             *   Третий (ряд 4) - второй ряд на два вниз и третий ряд на один вниз
             *   и так далее.
             * */
            canBeCapturedRows[i + 1] |= capturesOneRowBelow;
            canBeCapturedRows[i + 2] |= capturesTwoRowsBelow;
        }
        return noCaptures;
    }
}
