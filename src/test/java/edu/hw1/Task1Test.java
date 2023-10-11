package edu.hw1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task1Test {
    @Test
    @DisplayName("Тест с сайта 1")
    void test1() {
        long length = Task1.minutesToSeconds("01:00");
        assertThat(length).isEqualTo(60);
    }

    @Test
    @DisplayName("Тест с сайта 2")
    void test2() {
        long length = Task1.minutesToSeconds("13:56");
        assertThat(length).isEqualTo(836);
    }

    @Test
    @DisplayName("Тест с сайта 3")
    void test3() {
        long length = Task1.minutesToSeconds("10:60");
        assertThat(length).isEqualTo(-1);
    }

    @Test
    @DisplayName("Минут больше 100")
    void validString5() {
        long length = Task1.minutesToSeconds("3321:51");
        assertThat(length).isEqualTo(3321 * 60 + 51);
    }

    @Test
    @DisplayName("Только нули")
    void zeroString() {
        // Предполагаю, что такой вариант не допустим.
        long length = Task1.minutesToSeconds("00:00");
        assertThat(length).isEqualTo(-1);
    }

    @Test
    @DisplayName("Больше двух символов для секунд")
    void manyZeroesString() {
        long length = Task1.minutesToSeconds("00:001");
        assertThat(length).isEqualTo(-1);
    }

    @Test
    @DisplayName("Буквенные символы")
    void stringWithAlphabeticChars() {
        long length = Task1.minutesToSeconds("00:5a");
        assertThat(length).isEqualTo(-1);
    }

    @Test
    @DisplayName("Нет двоеточия")
    void plainNumberString() {
        long length = Task1.minutesToSeconds("10");
        assertThat(length).isEqualTo(-1);
    }
}
