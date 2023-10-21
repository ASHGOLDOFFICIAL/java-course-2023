package edu.hw1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public final class Task3Test {
    @Test
    @DisplayName("Тест из примера 1")
    void test1() {
        final long[] arr1 = {1, 2, 3, 4};
        final long[] arr2 = {0, 6};
        final boolean bool = Task3.isNestable(arr1, arr2);
        assertThat(bool).isTrue();
    }

    @Test
    @DisplayName("Тест из примера 2")
    void test2() {
        final long[] arr1 = {3, 1};
        final long[] arr2 = {4, 0};
        final boolean bool = Task3.isNestable(arr1, arr2);
        assertThat(bool).isTrue();
    }

    @Test
    @DisplayName("Тест из примера 3")
    void test3() {
        final long[] arr1 = {9, 9, 8};
        final long[] arr2 = {8, 9};
        final boolean bool = Task3.isNestable(arr1, arr2);
        assertThat(bool).isFalse();
    }

    @Test
    @DisplayName("Тест из примера 4")
    void test4() {
        final long[] arr1 = {1, 2, 3, 4};
        final long[] arr2 = {2, 3};
        final boolean bool = Task3.isNestable(arr1, arr2);
        assertThat(bool).isFalse();
    }

    @Test
    @DisplayName("Первый массив пустой")
    void firstArrayEmpty() {
//        Считаю, что пустой массив входит в любой массив (по аналогии с множествами).
        final long[] arr1 = {};
        final long[] arr2 = {2, 3};
        final boolean bool = Task3.isNestable(arr1, arr2);
        assertThat(bool).isTrue();
    }

    @Test
    @DisplayName("Второй массив пустой")
    void secondArrayEmpty() {
        final long[] arr1 = {1, 2};
        final long[] arr2 = {};
        final boolean bool = Task3.isNestable(arr1, arr2);
        assertThat(bool).isFalse();
    }

    @Test
    @DisplayName("Оба массива пустые")
    void bothArraysEmpty() {
        final long[] arr1 = {};
        final long[] arr2 = {};
        final boolean bool = Task3.isNestable(arr1, arr2);
        assertThat(bool).isTrue();
    }

    @SuppressWarnings("ConstantValue") // Он и должен быть false.
    @Test
    @DisplayName("Первый массив - null")
    void firstArrayNull() {
        final long[] arr1 = null;
        final long[] arr2 = {};
        final boolean bool = Task3.isNestable(arr1, arr2);
        assertThat(bool).isFalse();
    }

    @SuppressWarnings("ConstantValue") // Он и должен быть false.
    @Test
    @DisplayName("Второй массив - null")
    void secondArrayNull() {
        final long[] arr1 = {};
        final long[] arr2 = null;
        final boolean bool = Task3.isNestable(arr1, arr2);
        assertThat(bool).isFalse();
    }

    @SuppressWarnings("ConstantValue") // Он и должен быть false.
    @Test
    @DisplayName("Оба массива - null")
    void bothArrayNull() {
        final long[] arr1 = null;
        final long[] arr2 = null;
        final boolean bool = Task3.isNestable(arr1, arr2);
        assertThat(bool).isFalse();
    }

    @Test
    @DisplayName("Два массива из одного элемента")
    void singleValueArrays() {
        final long[] arr1 = {1};
        final long[] arr2 = {1};
        final boolean bool = Task3.isNestable(arr1, arr2);
        assertThat(bool).isFalse();
    }

    @Test
    @DisplayName("Два массива на 10 млн элементов")
    void massiveArrays() {
        final long[] arr1 = new long[10000000];
        final long[] arr2 = new long[10000000];
        final boolean bool = Task3.isNestable(arr1, arr2);
        assertThat(bool).isFalse();
    }
}
