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
}
