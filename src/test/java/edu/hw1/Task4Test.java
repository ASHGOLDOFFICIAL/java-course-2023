package edu.hw1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task4Test {
    @Test
    @DisplayName("Тест с сайта 0")
    void test0() {
        String fixedString = Task4.fixString("оПомигети псаривьтс ртко!и");
        assertThat(fixedString).isEqualTo("Помогите исправить строки!");
    }

    @Test
    @DisplayName("Тест с сайта 1")
    void test1() {
        String fixedString = Task4.fixString("123456");
        assertThat(fixedString).isEqualTo("214365");
    }

    @Test
    @DisplayName("Тест с сайта 2")
    void test2() {
        String fixedString = Task4.fixString("hTsii  s aimex dpus rtni.g");
        assertThat(fixedString).isEqualTo("This is a mixed up string.");
    }

    @Test
    @DisplayName("Тест с сайта 3")
    void test3() {
        String fixedString = Task4.fixString("badce");
        assertThat(fixedString).isEqualTo("abcde");
    }

    @Test
    @DisplayName("Пустая строка")
    void emptyLine() {
        String fixedString = Task4.fixString("");
        assertThat(fixedString).isEqualTo("");
    }
}