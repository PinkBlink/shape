package org.triangle;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.triangle.entity.Point;
import org.triangle.entity.Triangle;
import org.triangle.action.TriangleAnalyzer;
import org.triangle.exception.CollinearPointsException;

public class TriangleAnalyserTest {
    Point p1;
    Point p2;
    Point p3;
    Triangle triangle;
    TriangleAnalyzer analyzer;

    @BeforeTest
    public void setUp() {
        p1 = new Point(0, 0);
        p2 = new Point(0, 4);
        p3 = new Point(4, 4);
        triangle = new Triangle(p1, p2, p3);
        analyzer = new TriangleAnalyzer(triangle);
    }

    @Test
    public void testRightTriangle() {
        Assert.assertTrue(analyzer.isRightTriangle(), "must be right");
    }

    @Test
    public void testTriangleSquare() {
        double expectedValue = 8;
        double actualValue = analyzer.getTriangleSquare();
        Assert.assertEquals(actualValue, expectedValue, "Must be " + expectedValue + " but is : " + actualValue);
    }

    @Test
    public void testTrianglePerimeter() {
        double expectedValue = 13.66;
        double actualValue = analyzer.getTrianglePerimeter();
        Assert.assertEquals(actualValue, 13.66, "Must be " + expectedValue + "but is " + actualValue);
    }

    @Test
    public void samePointAnalyzerConstructorThrowTest() {
        Point samePoint = new Point(0, 0);
        Triangle invalidTriangle = new Triangle(samePoint, samePoint
                , samePoint);
        Assert.assertThrows(CollinearPointsException.class, () -> {
            new TriangleAnalyzer(invalidTriangle);
        });
    }

    @Test
    public void oneLinePointsAnalyzerConstructorThrowTest() {
        Point firstPoint = new Point(1, 1);
        Point secondPoint = new Point(2, 2);
        Point thirdPoint = new Point(3, 3);

        Triangle invalidTriangle = new Triangle(firstPoint, secondPoint
                , thirdPoint);
        Assert.assertThrows(CollinearPointsException.class, () -> {
            new TriangleAnalyzer(invalidTriangle);
        });
    }
}
