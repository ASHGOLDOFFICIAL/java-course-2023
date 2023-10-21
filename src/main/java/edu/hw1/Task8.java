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
         * */

        if (board.length != BOARD_SIZE) {
            throw new IllegalArgumentException("Array's length should be 8");
        }

        /*
         * int[10] canBeCapturedRows - набор таких чисел, в двоичной записи которых единица обозначает, что существует
         *   конь, способный захватить эту клетку, а ноль - что ни один конь эту клетку захватить не может. Так как
         *   мы расширили поле вниз на два ряда для ходов коня, то размер массива - 10, а не 8.
         * */
        int[] canBeCapturedRows = new int[BOARD_SIZE + 2];
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
                 * Число 5 в двоичной записи - 101. Ситуация аналогичная с числом 17. Только делаем сдвиг на 1, так как
                 * во втором ряду от себя конь ходит на 1 в сторону, а не на 2, как в случае с первым рядом от себя.
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
             * Обновим "ряды захвата" в соответствии с положениями коней на данном ряду. Объединяем, чтобы не потерять
             * захваты коней с предыдущих рядов.
             * */
            canBeCapturedRows[i + 1] |= capturesOneRowBelow;
            canBeCapturedRows[i + 2] |= capturesTwoRowsBelow;
        }
        return noCaptures;
    }
}
