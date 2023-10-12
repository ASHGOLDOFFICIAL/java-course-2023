package edu.hw1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task6Test {
    @Test
    @DisplayName("Тест с сайта 0")
    void test0() {
        int bool = Task6.countK(3524);
        assertThat(bool).isEqualTo(3);
    }

    @Test
    @DisplayName("Тест с сайта 1")
    void test1() {
        int bool = Task6.countK(6621);
        assertThat(bool).isEqualTo(5);
    }

    @Test
    @DisplayName("Тест с сайта 2")
    void test2() {
        int bool = Task6.countK(6554);
        assertThat(bool).isEqualTo(4);
    }

    @Test
    @DisplayName("Тест с сайта 3")
    void test3() {
        int bool = Task6.countK(1234);
        assertThat(bool).isEqualTo(3);
    }

    @Test
    @DisplayName("Число 1000")
    void number1000() {
        int bool = Task6.countK(1000);
        assertThat(bool).isEqualTo(-1);
    }

    @Test
    @DisplayName("Меньше четырёхзачного")
    void lessThanFourDigits() {
        int bool = Task6.countK(500);
        assertThat(bool).isEqualTo(-1);
    }

    @Test
    @DisplayName("Больше четырёхзначного")
    void moreThanFourDigits() {
        int bool = Task6.countK(50000);
        assertThat(bool).isEqualTo(-1);
    }

    @Test
    @DisplayName("Отрицательное")
    void negative() {
        int bool = Task6.countK(-1000);
        assertThat(bool).isEqualTo(-1);
    }
}
