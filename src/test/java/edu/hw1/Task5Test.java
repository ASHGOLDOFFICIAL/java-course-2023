package edu.hw1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task5Test {
    @Test
    @DisplayName("Тест с сайта 0")
    void test0() {
        boolean bool = Task5.isPalindromeDescendant(123312);
        assertThat(bool).isTrue();
    }

    @Test
    @DisplayName("Тест с сайта 1")
    void test1() {
        boolean bool = Task5.isPalindromeDescendant(11211230);
        assertThat(bool).isTrue();
    }

    @Test
    @DisplayName("Тест с сайта 2")
    void test2() {
        boolean bool = Task5.isPalindromeDescendant(13001120);
        assertThat(bool).isTrue();
    }

    @Test
    @DisplayName("Тест с сайта 3")
    void test3() {
        boolean bool = Task5.isPalindromeDescendant(23336014);
        assertThat(bool).isTrue();
    }

    @Test
    @DisplayName("Тест с сайта 4")
    void test4() {
        boolean bool = Task5.isPalindromeDescendant(11);
        assertThat(bool).isTrue();
    }

    @Test
    @DisplayName("Число 9910")
    void number9910() {
        boolean bool = Task5.isPalindromeDescendant(9910);
        assertThat(bool).isTrue();
    }

    @Test
    @DisplayName("Число 1377")
    void number1377() {
        boolean bool = Task5.isPalindromeDescendant(1377);
        assertThat(bool).isTrue();
    }

    @Test
    @DisplayName("Число 130177")
    void number130177() {
        boolean bool = Task5.isPalindromeDescendant(130177);
        assertThat(bool).isTrue();
    }

    @Test
    @DisplayName("Число 93287")
    void number93287() {
        boolean bool = Task5.isPalindromeDescendant(93287);
        assertThat(bool).isFalse();
    }

    @Test
    @DisplayName("Число 2")
    void number2() {
        boolean bool = Task5.isPalindromeDescendant(2);
        assertThat(bool).isFalse();
    }
}
