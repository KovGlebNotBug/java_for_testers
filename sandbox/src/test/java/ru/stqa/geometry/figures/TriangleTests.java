package ru.stqa.geometry.figures;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TriangleTests {

    @Test
    void canCalculatePerimeter () {
        var t = new Triangle(3.,4.,5.);
        var result = t.trianglePerimeter();
        Assertions.assertEquals(12,result);
    }

    @Test
    void canCalculateArea () {
        var t = new Triangle(5.,6.,2.2);
        var result = t.triangleArea();
        Assertions.assertEquals(5.279999999999998, result);
    }

    @Test
    void cannotCreateTriangleWithNegativeSide() {
        try {
            new Triangle(-4, 0, 5);
            System.out.println("Test fail");
            Assertions.fail();
        } catch (IllegalArgumentException exception) {
            System.out.println("Test passed");

        }
    }
    @Test
    void cannotCreateTriangleWithZeroSide() {
        try {
            new Triangle(4, 0, 5);
            System.out.println("Test fail");
            Assertions.fail();
        } catch (IllegalArgumentException exception) {
            System.out.println(exception);

        }
    }

    @Test
    void sumTwoSidesCannotBeLessThirdSide () {
        try {
            new Triangle(9,7,1);
            System.out.println("Test fail");
            Assertions.fail();
        } catch (IllegalArgumentException exception) {
            System.out.println(exception);
        }
    }

    @Test
    void strictComparisonOfTriangles() {
        var t1 = new Triangle(9,7,5);
        var t2 = new Triangle(9,7,5);
        Assertions.assertEquals(t1, t2);
    }

    @Test
    void flexibleTriangleComparison() {
        var t1 = new Triangle(7,5,9);
        var t2 = new Triangle(9,7,5);
        Assertions.assertEquals(t1, t2);
    }


}

