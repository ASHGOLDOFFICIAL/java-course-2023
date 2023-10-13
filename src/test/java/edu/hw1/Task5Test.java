package edu.hw1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public final class Task5Test {
    @Test
    @DisplayName("Тест из примера 0")
    void test0() {
        final boolean bool = Task5.isPalindromeDescendant(123312);
        assertThat(bool).isTrue();
    }

    @Test
    @DisplayName("Тест из примера 1")
    void test1() {
        final boolean bool = Task5.isPalindromeDescendant(11211230);
        assertThat(bool).isTrue();
    }

    @Test
    @DisplayName("Тест из примера 2")
    void test2() {
        final boolean bool = Task5.isPalindromeDescendant(13001120);
        assertThat(bool).isTrue();
    }

    @Test
    @DisplayName("Тест из примера 3")
    void test3() {
        final boolean bool = Task5.isPalindromeDescendant(23336014);
        assertThat(bool).isTrue();
    }

    @Test
    @DisplayName("Тест из примера 4")
    void test4() {
        final boolean bool = Task5.isPalindromeDescendant(11);
        assertThat(bool).isTrue();
    }

    @Test
    @DisplayName("Число 9910")
    void number9910() {
        final boolean bool = Task5.isPalindromeDescendant(9910);
        assertThat(bool).isTrue();
    }

    @Test
    @DisplayName("Число 1377")
    void number1377() {
        final boolean bool = Task5.isPalindromeDescendant(1377);
        assertThat(bool).isTrue();
    }

    @Test
    @DisplayName("Число 130177")
    void number130177() {
        final boolean bool = Task5.isPalindromeDescendant(130177);
        assertThat(bool).isTrue();
    }

    @Test
    @DisplayName("Число 93287")
    void number93287() {
        final boolean bool = Task5.isPalindromeDescendant(93287);
        assertThat(bool).isFalse();
    }

    @Test
    @DisplayName("Число 2")
    void number2() {
        final boolean bool = Task5.isPalindromeDescendant(2);
        assertThat(bool).isFalse();
    }
}
