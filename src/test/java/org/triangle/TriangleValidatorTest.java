package org.triangle;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.triangle.entity.Point;
import org.triangle.entity.Triangle;
import org.triangle.utils.TriangleValidator;

public class TriangleValidatorTest {
    String invalidCoordinates;
    String validCoordinates;
    Triangle invalidTriangle;
    Triangle validTriangle;

    @BeforeTest
    public void setUp() {
        invalidTriangle = new Triangle(new Point(0, 0), new Point(0, 1), new Point(0, 0));
        validTriangle = new Triangle(new Point(0, 0), new Point(1, 0), new Point(0, 1));
        invalidCoordinates = "1.0 0.0 0.0 1.0 0.0 1.2 ";
        validCoordinates = "1.0 0.0 0.0 1.0 0.0 1.2";
    }
    @Test
    public void isValidCoordinatesStringIfInvalidCoordinatesShouldReturnFalseTest() {
        boolean result = TriangleValidator.isValidCoordinatesString(invalidCoordinates);
        Assert.assertFalse(result);
    }

    @Test
    public void isValidCoordinatesStringIfValidCoordinates_ShouldReturnTrueTest() {
        boolean result = TriangleValidator.isValidCoordinatesString(validCoordinates);
        Assert.assertTrue(result);
    }
}
