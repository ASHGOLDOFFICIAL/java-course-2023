package edu.hw2;

import edu.Task;

public final class Task1 extends Task {
    private Task1() {
    }

    public sealed interface Expr {
        double evaluate();

        record Constant(double num) implements Expr {
            @Override
            public double evaluate() {
                return this.num();
            }
        }

        record Negate(Expr num) implements Expr {
            @Override
            public double evaluate() {
                return -num.evaluate();
            }
        }

        record Addition(Expr a, Expr b) implements Expr {
            @Override
            public double evaluate() {
                return a.evaluate() + b.evaluate();
            }
        }

        record Multiplication(Expr a, Expr b) implements Expr {
            @Override
            public double evaluate() {
                return a.evaluate() * b.evaluate();
            }
        }

        record Exponent(Expr num, double power) implements Expr {
            @Override
            public double evaluate() {
                return Math.pow(num.evaluate(), power);
            }
        }
    }
}
