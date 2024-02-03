package ru.stqa.geometry;

import ru.stqa.geometry.figures.Triangle;

import java.util.List;
import java.util.function.Consumer;

public class Geometry {
    public static void main(String[] args) {
        var triangles = List.of(
                new Triangle(3,4,5),
                new Triangle(3,4,5),
                new Triangle(3,4,5));
//        for (Triangle triangle : triangles) {
//            Triangle.printTrianglePerimeter(triangle);
//        }

        //пример функционального стиля написания кода
        // переменная print указана только для примера, по факту она не нужна
        Consumer<Triangle> print = Triangle::printTrianglePerimeter;
        triangles.forEach(print);

        // forEach() заменяет -> исходный код в императивном стиле
        // for (Triangle triangle : triangles) {
        //  Triangle.printTrianglePerimeter(triangle);
        //}
        // итоговая реализация примера написания кода в функциональном стиле
        triangles.forEach(Triangle::printTrianglePerimeter);

//        Triangle.printTrianglePerimeter(new Triangle(3,4,5));
//
//        Triangle.printTriangleArea(new Triangle(6., 5., 2.2));
    }
}
