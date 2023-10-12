package edu.hw1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task7Test {
    @Test
    @DisplayName("Тест из примера 1")
    void test1() {
        final int num = Task7.rotateRight(8, 1);
        assertThat(num).isEqualTo(4);
    }

    @Test
    @DisplayName("Тест из примера 2")
    void test2() {
        final int num = Task7.rotateLeft(16, 1);
        assertThat(num).isEqualTo(1);
    }

    @Test
    @DisplayName("Тест из примера 3")
    void test3() {
        final int num = Task7.rotateLeft(17, 2);
        assertThat(num).isEqualTo(6);
    }

    @Test
    @DisplayName("Сдвиг вправо на 1: число 1")
    void rotateRight1() {
        final int num = Task7.rotateRight(1, 1);
        assertThat(num).isEqualTo(1);
    }

    @Test
    @DisplayName("Сдвиг вправо на 2: число 2")
    void rotateRight2() {
        final int num = Task7.rotateRight(2, 2);
        assertThat(num).isEqualTo(2);
    }

    @Test
    @DisplayName("Сдвиг вправо на 2: число 4")
    void rotateRight4() {
        final int num = Task7.rotateRight(4, 2);
        assertThat(num).isEqualTo(1);
    }

    @Test
    @DisplayName("Сдвиг вправо на 101: число 8")
    void rotateRight8() {
        final int num = Task7.rotateRight(8, 101);
        assertThat(num).isEqualTo(4);
    }

    @Test
    @DisplayName("Сдвиг вправо на 1: число 11")
    void rotateRight11() {
        final int num = Task7.rotateRight(11, 1);
        assertThat(num).isEqualTo(13);
    }

    @Test
    @DisplayName("Сдвиг вправо на 1: число 9")
    void rotateRight9() {
        final int num = Task7.rotateRight(9, 1);
        assertThat(num).isEqualTo(12);
    }

    @Test
    @DisplayName("Сдвиг влево на 1: число 1")
    void rotateLeft1() {
        final int num = Task7.rotateLeft(1, 1);
        assertThat(num).isEqualTo(1);
    }

    @Test
    @DisplayName("Сдвиг влево на 2: число 2")
    void rotateLeft() {
        final int num = Task7.rotateLeft(2, 2);
        assertThat(num).isEqualTo(2);
    }

    @Test
    @DisplayName("Сдвиг влево на 1: число 9")
    void rotateLeft9() {
        final int num = Task7.rotateLeft(9, 1);
        assertThat(num).isEqualTo(3);
    }

    @Test
    @DisplayName("Сдвиг влево на 3: число 24")
    void rotateLeft24() {
        final int num = Task7.rotateLeft(24, 3);
        assertThat(num).isEqualTo(6);
    }
    @Test
    @DisplayName("Сдвиг влево на 101: число 8")
    void rotateLeft8() {
        final int num = Task7.rotateLeft(8, 101);
        assertThat(num).isEqualTo(1);
    }
}
