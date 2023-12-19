package ru.stqa.geometry.figures;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TriangleTests {

    @Test
    void canCalculateArea () {
        var a = 6.;
        var b = 5.;
        var c = 2.2;
        var result1 = Triangle.semiperimeter(a,b,c);
        Assertions.assertEquals (6.6, result1);
        var result2 = Triangle.triangleArea(a,b,c,result1);
        Assertions.assertEquals(5.279999999999998,result2);

    }

    @Test
    void canCalculatePerimeter () {
        var result = Triangle.trianglePerimeter(3,4,5);
        Assertions.assertEquals(12,result);

    }
}
