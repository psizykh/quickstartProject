package com.geekbrains.Lesson4;


import Lesson4.TriangleArea;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CalcAreaTest {
    @Test
    void successSquareCalculation() throws Exception {
        Assertions.assertEquals(TriangleArea.calcArea(3, 4, 5), 6);
        Assertions.assertTrue(Math.abs(TriangleArea.calcArea(3, 4, 5) - 6) < 0.0001);
        Assertions.assertEquals(6, TriangleArea.calcArea(3, 4, 5), 0.0002);
    }

    @Test
    void negativeTriangleTest() {
        Assertions.assertThrows(Exception.class, () -> TriangleArea.calcArea(-3, 4, 5));
    }



}


