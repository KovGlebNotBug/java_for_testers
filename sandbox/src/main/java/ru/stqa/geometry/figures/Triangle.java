package ru.stqa.geometry.figures;

import java.math.RoundingMode;

public class Triangle {

    public static void printTriangleArea(double a, double b, double c) {
        // Вопрос! Если использую для ввывода эту строку, то результат расчёта = 5.28, при этом в тесте расчёт = 5.279999999999998
        // String textArea = String.format("Площядь треуголника с сторонами %.1f / %.1f / %.1f = %f ", a, b, c, triangleArea(a,b,c));
        String textArea = String.format("Площядь треуголника с сторонами %.1f / %.1f / %.1f = " + triangleArea(a,b,c), a, b, c);
        System.out.println(textArea);
    }

    public static double triangleArea(double a, double b, double c) {
        var p = (a + b + c) / 2;
        return Math.sqrt(p * (p - a) * (p - b) * (p - c));
    }

    public static void printTrianglePerimeter(double sideA, double b, double c){
        String textPerimeter = String.format("Периметр треуголника с сторонами %.1f / %.1f / %.1f = %.2f" , sideA, b, c, trianglePerimeter(sideA, b, c));
        System.out.println(textPerimeter);
    }

    public static double trianglePerimeter(double a, double b, double c) {
        return a + b + c;
    }
}
