package edu.hw3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public final class Task1Test {
    @Test
    @DisplayName("Тест из примера 1")
    void test1() {
        final String str = Task1.atbash("Hello world!");
        assertThat(str).isEqualTo("Svool dliow!");
    }

    @Test
    @DisplayName("Тест из примера 2")
    void test2() {
        final String str = Task1.atbash("Any fool can write code that a computer can understand. "
                + "Good programmers write code that humans can understand. ― Martin Fowler");
        assertThat(str).isEqualTo("Zmb ullo xzm dirgv xlwv gszg z xlnkfgvi xzm fmwvihgzmw. "
                + "Tllw kiltiznnvih dirgv xlwv gszg sfnzmh xzm fmwvihgzmw. ― Nzigrm Uldovi"
        );
    }
}
