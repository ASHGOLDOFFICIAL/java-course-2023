package edu.hw1;

import edu.Task;

public final class Task3 extends Task {
    private Task3() {
    }

    public static boolean isNestable(long[] arr1, long[] arr2) {
//        Если один из массивов - null, то вложение провести нельзя.
        if (arr1 == null || arr2 == null) {
            return false;
        }
//        Если второй массив пуст, то вложение провести можно только при условии, что первый тоже пуст.
        if (arr2.length == 0) {
            return (arr1.length == 0);
        }

        long[] arr1MinMax = new long[]{Long.MAX_VALUE, Long.MIN_VALUE};
        long[] arr2MinMax = new long[]{Long.MAX_VALUE, Long.MIN_VALUE};

        for (long l : arr1) {
            arr1MinMax[0] = Math.min(arr1MinMax[0], l);
            arr1MinMax[1] = Math.max(arr1MinMax[1], l);
        }

        for (long l : arr2) {
            arr2MinMax[0] = Math.min(arr2MinMax[0], l);
            arr2MinMax[1] = Math.max(arr2MinMax[1], l);
        }

        return (arr1MinMax[0] > arr2MinMax[0] && arr1MinMax[1] < arr2MinMax[1]);
    }
}
