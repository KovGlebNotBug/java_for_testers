package ru.stqa.geometry.figures;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TriangleTests {

    @Test
    void canCalculatePerimeter () {
        var result = Triangle.trianglePerimeter(3,4,5);
        Assertions.assertEquals(12,result);
    }

    @Test
    void canCalculateArea () {
        var result = Triangle.triangleArea(5.,6.,2.2);
        Assertions.assertEquals(5.279999999999998, result);
    }
}
