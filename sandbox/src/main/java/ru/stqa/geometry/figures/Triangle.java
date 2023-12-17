package ru.stqa.geometry.figures;

public class Triangle {

    public static void printTriangleArea(double a, double b, double c) {
        var p = semiperimeter(a, b, c);
        var s = triangleArea(a, b, c, p);
        String textArea = String.format("Площядь треуголника с сторонами %.1f / %.1f / %.1f = %.2f", a, b, c, s);
        System.out.println(textArea);
    }

    private static double triangleArea(double a, double b, double c, double p) {
        return Math.sqrt(p * (p - a) * (p - b) * (p - c));
    }

    private static double semiperimeter(double a, double b, double c) {
        return (a + b + c) / 2;

    }

    public static void printTrianglePerimeter(double sideA, double b, double c){
        String textPerimeter = String.format("Периметр треуголника с сторонами %.1f / %.1f / %.1f = %.2f" , sideA, b, c, trianglePerimeter(sideA, b, c));
        System.out.println(textPerimeter);
    }

    private static double trianglePerimeter(double a, double b, double c) {
        return a + b + c;
    }
}
