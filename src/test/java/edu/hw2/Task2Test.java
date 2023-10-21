package edu.hw2;

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
    void rectangleArea(Task2.Rectangle rect) {
        Task2.Rectangle newRect = rect.setWidth(20).setHeight(10);

        assertThat(newRect.area()).isEqualTo(200.0);
    }
}
