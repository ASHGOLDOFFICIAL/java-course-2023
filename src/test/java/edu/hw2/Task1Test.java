package edu.hw2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import edu.hw2.Task1.Expr;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public final class Task1Test {
    @Test
    @DisplayName("Тест из примера")
    void test() {
        var two = new Expr.Constant(2);
        var four = new Expr.Constant(4);
        var negOne = new Expr.Negate(new Expr.Constant(1));
        var sumTwoFour = new Expr.Addition(two, four);
        var mult = new Expr.Multiplication(sumTwoFour, negOne);
        var exp = new Expr.Exponent(mult, 2);
        var res = new Expr.Addition(exp, new Expr.Constant(1));

        assertThat(res.evaluate()).isEqualTo(37);
    }

    @Test
    @DisplayName("Возведение в отрицательную степень целого числа")
    void wholeNumNegPower() {
        var expr = new Expr.Exponent(new Expr.Constant(2), -1);
        assertThat(expr.evaluate()).isEqualTo(1.0 / 2.0);
    }

    @Test
    @DisplayName("Возведение в отрицательную степень рационального числа")
    void rationalNumNegPower() {
        var expr = new Expr.Exponent(new Expr.Constant(1.0 / 2.0), -1);
        assertThat(expr.evaluate()).isEqualTo(2.0);
    }

    @Test
    @DisplayName("Возведение в отрицательную степень рационального числа")
    void negRationalNumRationalPower() {
        var expr = new Expr.Exponent(new Expr.Constant(-4), 1.0 / 2.0);
        assertThat(expr.evaluate()).isNaN();
    }

    @Test
    @DisplayName("Возведение в рациональную степень отрицательного числа")
    void negNumRationalPower() {
        var expr = new Expr.Exponent(new Expr.Constant(-4), 1.0 / 2.0);
        assertThat(expr.evaluate()).isNaN();
    }
}
