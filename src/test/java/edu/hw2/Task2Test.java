package edu.hw2;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public final class Task2Test {
    static Arguments[] rectangles() {
        return new Arguments[]{
                Arguments.of(new Task2.Rectangle()),
                Arguments.of(new Task2.Square())
        };
    }

    @ParameterizedTest
    @MethodSource("rectangles")
    @DisplayName("Площади фигур")
    void rectangleArea(Task2.Rectangle rect) {
        Task2.Rectangle newRect = rect.setWidth(20).setHeight(10);
        assertThat(newRect.area()).isEqualTo(200.0);
    }

    @Test
    @DisplayName("Площадь квадрата")
    void squareArea() {
        Task2.Rectangle square = new Task2.Square().setSize(20);
        assertThat(square.area()).isEqualTo(400.0);
    }
}
