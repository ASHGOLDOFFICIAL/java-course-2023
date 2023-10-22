package edu.hw2;

import edu.Consts;

public final class Task2 extends Consts {
    private Task2() {
    }

    public static class Rectangle {
        protected int width;
        protected int height;

        Rectangle setWidth(int width) {
            Rectangle rect = new Rectangle();
            rect.height = this.height;
            rect.width = width;
            return rect;
        }

         Rectangle setHeight(int height) {
            Rectangle rect = new Rectangle();
            rect.height = height;
            rect.width = this.width;
            return rect;
         }

        double area() {
            return width * height;
        }
    }

    public static class Square extends Rectangle {
        Rectangle setSize(int size) {
            Square square = new Square();
            square.height = size;
            square.width = size;
            return square;
        }
    }
}