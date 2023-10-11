package edu.hw1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task3Test {
    @Test
    @DisplayName("Тест с сайта 1")
    void test1() {
        long[] arr1 = {1, 2, 3, 4};
        long[] arr2 = {0, 6};
        boolean bool = Task3.isNestable(arr1, arr2);
        assertThat(bool).isTrue();
    }

    @Test
    @DisplayName("Тест с сайта 2")
    void test2() {
        long[] arr1 = {3, 1};
        long[] arr2 = {4, 0};
        boolean bool = Task3.isNestable(arr1, arr2);
        assertThat(bool).isTrue();
    }

    @Test
    @DisplayName("Тест с сайта 3")
    void test3() {
        long[] arr1 = {9, 9, 8};
        long[] arr2 = {8, 9};
        boolean bool = Task3.isNestable(arr1, arr2);
        assertThat(bool).isFalse();
    }

    @Test
    @DisplayName("Тест с сайта 4")
    void test4() {
        long[] arr1 = {1, 2, 3, 4};
        long[] arr2 = {2, 3};
        boolean bool = Task3.isNestable(arr1, arr2);
        assertThat(bool).isFalse();
    }

    @Test
    @DisplayName("Первый массив пустой")
    void firstArrayEmpty() {
//        Считаю, что пустой массив входит в любой массив (по аналогии с множествами).
        long[] arr1 = {};
        long[] arr2 = {2, 3};
        boolean bool = Task3.isNestable(arr1, arr2);
        assertThat(bool).isTrue();
    }

    @Test
    @DisplayName("Второй массив пустой")
    void secondArrayEmpty() {
        long[] arr1 = {1, 2};
        long[] arr2 = {};
        boolean bool = Task3.isNestable(arr1, arr2);
        assertThat(bool).isFalse();
    }

    @Test
    @DisplayName("Оба массива пустые")
    void bothArraysEmpty() {
        long[] arr1 = {};
        long[] arr2 = {};
        boolean bool = Task3.isNestable(arr1, arr2);
        assertThat(bool).isTrue();
    }

    @SuppressWarnings("ConstantValue") // Он и должен быть false.
    @Test
    @DisplayName("Первый массив - null")
    void firstArrayNull() {
        long[] arr1 = null;
        long[] arr2 = {};
        boolean bool = Task3.isNestable(arr1, arr2);
        assertThat(bool).isFalse();
    }

    @SuppressWarnings("ConstantValue") // Он и должен быть false.
    @Test
    @DisplayName("Второй массив - null")
    void secondArrayNull() {
        long[] arr1 = {};
        long[] arr2 = null;
        boolean bool = Task3.isNestable(arr1, arr2);
        assertThat(bool).isFalse();
    }

    @SuppressWarnings("ConstantValue") // Он и должен быть false.
    @Test
    @DisplayName("Оба массива - null")
    void bothArrayNull() {
        long[] arr1 = null;
        long[] arr2 = null;
        boolean bool = Task3.isNestable(arr1, arr2);
        assertThat(bool).isFalse();
    }

    @Test
    @DisplayName("Два массива из одного элемента")
    void singleValueArrays() {
        long[] arr1 = {1};
        long[] arr2 = {1};
        boolean bool = Task3.isNestable(arr1, arr2);
        assertThat(bool).isFalse();
    }
}
