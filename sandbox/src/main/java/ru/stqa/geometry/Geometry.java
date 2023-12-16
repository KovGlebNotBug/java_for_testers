package ru.stqa.geometry;

public class Geometry {
    public static void main(String[] args) {
        printTrianglePerimeter(3,4,5);

        printTriangleArea(6, 5, 2.2);

    }

    private static void printTriangleArea(double a, double b, double c) {
        var p = semiperimeter(a, b, c);
        var s = triangleArea(a, b, c, p);
        /*
        //If you want to round the output
        var s1 = String.format("%.2f", s);
        */
        System.out.println("Площядь треуголника с сторонами " + a + ", " + b + " и " + c + " = " + s);
    }

    private static double triangleArea(double a, double b, double c, double p) {
        return Math.sqrt(p * (p - a) * (p - b) * (p - c));
    }
    private static double semiperimeter(double a, double b, double c) {
        return (a + b + c) / 2;

    }


    static void printTrianglePerimeter(double sideA, double b, double c){
        System.out.println("Периметр треуголника с сторонами " + sideA + ", " + b + " и " + c + " = " + trianglePerimeter(sideA, b, c));
    }

    private static double trianglePerimeter(double a, double b, double c) {
        return a + b + c;
    }
}
