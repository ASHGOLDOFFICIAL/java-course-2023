package edu.hw1;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Task2Test {
    @Test
    @DisplayName("Тест с сайта 1")
    void test1() {
        int digits = Task2.countDigits(4666);
        assertThat(digits).isEqualTo(4);
    }

    @Test
    @DisplayName("Тест с сайта 2")
    void test2() {
        int digits = Task2.countDigits(544);
        assertThat(digits).isEqualTo(3);
    }

    @Test
    @DisplayName("Тест с сайта 3")
    void test3() {
        int digits = Task2.countDigits(0);
        assertThat(digits).isEqualTo(1);
    }
}
