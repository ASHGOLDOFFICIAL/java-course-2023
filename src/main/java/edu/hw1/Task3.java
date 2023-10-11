package edu.hw1;

import edu.Task;

public class Task3 extends Task {
    private Task3() {}

    public static boolean isNestable(long[] arr1, long[] arr2) {
//        Если один из массивов - null, то вложение провести нельзя.
        if (arr1 == null || arr2 == null) {
            return false;
        }
//        Если второй массив пуст, то вложение провести можно только при условии, что первый тоже пуст.
        if (arr2.length == 0) {
            return (arr1.length == 0);
        }

        long arr1Min = Long.MAX_VALUE;
        long arr1Max = Long.MIN_VALUE;
        long arr2Min = Long.MAX_VALUE;
        long arr2Max = Long.MIN_VALUE;

        int minLength, maxLength;
        if (arr1.length >= arr2.length) {
            minLength = arr2.length;
            maxLength = arr1.length;
        } else {
            minLength = arr1.length;
            maxLength = arr2.length;
        }

//        В коде используется функция min/max для нахождения наименьшего/наибольшего значения
//        из пары, чтобы не писать ветвлений или тернарных операторов для простых случаев.

//        Итерируемся сквозь оба массива, пока это возможно (до тех пор, пока мы не выйдем за пределы наименьшего).
        for (int i = 0; i < minLength; i++) {
            arr1Min = Math.min(arr1Min, arr1[i]);
            arr2Min = Math.min(arr2Min, arr2[i]);
            arr1Max = Math.max(arr1Max, arr1[i]);
            arr2Max = Math.max(arr2Max, arr2[i]);
        }

//        Итерируемся сквозь остаток наибольшего массива.
        for (int i = minLength; i < maxLength; i++) {
            if (arr1.length >= arr2.length) {
                arr1Min = Math.min(arr1Min, arr1[i]);
                arr1Max = Math.max(arr1Min, arr1[i]);
            } else {
                arr2Min = Math.min(arr2Min, arr2[i]);
                arr2Max = Math.max(arr2Max, arr2[i]);
            }
        }

        return (arr1Min > arr2Min && arr1Max < arr2Max);
    }
}
