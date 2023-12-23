package ru.stqa.geometry.figures;



public record Triangle(double sideA, double sideB, double sideC) {

    public static void printTriangleArea(Triangle t) {
        String textArea = String.format("Площядь треуголника с сторонами %.1f / %.1f / %.1f = " + t.triangleArea(), t.sideA, t.sideB, t.sideC);
        System.out.println(textArea);
    }

    public static void printTrianglePerimeter(Triangle t){
        String textPerimeter = String.format("Периметр треуголника с сторонами %.1f / %.1f / %.1f = %.2f" , t.sideA, t.sideB, t.sideC, t.trianglePerimeter());
        System.out.println(textPerimeter);
    }

    public double trianglePerimeter() {
        return this.sideA + this.sideB + this.sideC;
    }

    public double triangleArea() {
        var p = trianglePerimeter() / 2;
        return Math.sqrt(p * (p - this.sideA) * (p - this.sideB) * (p - this.sideC));

    }
}
