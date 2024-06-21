package org.triangle;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.triangle.entity.Point;
import org.triangle.entity.Triangle;
import org.triangle.utils.Inspector;

public class InspectorTest {
    String wrongCoordinates;
    String validCoordinates;
    Triangle invalidTriangle;
    Triangle validTriangle;

    @BeforeTest
    public void setUp() {
        invalidTriangle = new Triangle(new Point(0, 0), new Point(0, 1), new Point(0, 0));
        validTriangle = new Triangle(new Point(0, 0), new Point(1, 0), new Point(0, 1));
        wrongCoordinates = "1.0 0.0 0.0 1.0 0.0 1.2 ";
        validCoordinates = "1.0 0.0 0.0 1.0 0.0 1.2";
    }

    @Test
    public void isValidCoordinatesNegativeTest() {
        Assert.assertFalse(Inspector.isValidCoordinatesString(wrongCoordinates));
    }

    @Test
    public void isValidCoordinatesPositiveTest() {
        Assert.assertTrue(Inspector.isValidCoordinatesString(validCoordinates));
    }

//    @Test
//    public void isValidTriangleNegativeTest() {
//        Assert.assertFalse(Inspector.isValidTriangle(invalidTriangle));
//    }
//
//    @Test
//    public void isValidTrianglePositiveTest() {
//        Assert.assertTrue(Inspector.isValidTriangle(validTriangle));
//    }
}
