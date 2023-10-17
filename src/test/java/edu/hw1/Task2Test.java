package edu.hw1;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public final class Task2Test {
    @Test
    @DisplayName("Тест из примера 1")
    void test1() {
        final int digits = Task2.countDigits(4666);
        assertThat(digits).isEqualTo(4);
    }

    @Test
    @DisplayName("Тест из примера 2")
    void test2() {
        final int digits = Task2.countDigits(544);
        assertThat(digits).isEqualTo(3);
    }

    @Test
    @DisplayName("Тест из примера 3")
    void test3() {
        final int digits = Task2.countDigits(0);
        assertThat(digits).isEqualTo(1);
    }
}
