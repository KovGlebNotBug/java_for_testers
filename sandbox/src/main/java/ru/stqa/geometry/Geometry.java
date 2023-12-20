package ru.stqa.geometry;

import ru.stqa.geometry.figures.Triangle;

public class Geometry {
    public static void main(String[] args) {
        Triangle.printTrianglePerimeter(new Triangle(3,4,5));

        Triangle.printTriangleArea(new Triangle(6., 5., 2.2));

    }


}
