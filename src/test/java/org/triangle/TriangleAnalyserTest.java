package org.triangle;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.triangle.entity.Point;
import org.triangle.entity.Triangle;
import org.triangle.action.TriangleAnalyzer;

public class TriangleAnalyserTest {
    Triangle triangle;
    Triangle rightAndScaleneTriangle;
    Triangle obtuseAndIsoscelesTriangle;
    Triangle acuteAndScaleneTriangle;
    Triangle equilateralTriangle;
    TriangleAnalyzer analyzer;

    @BeforeTest
    public void setUp() {
        triangle = new Triangle(new Point(0, 0), new Point(0, 4), new Point(4, 4));
        rightAndScaleneTriangle = new Triangle(new Point(0, 0), new Point(3, 0), new Point(0, 4));
        obtuseAndIsoscelesTriangle = new Triangle(new Point(0, 0), new Point(0, 6), new Point(1, 3));
        acuteAndScaleneTriangle = new Triangle(new Point(0, 0), new Point(2, 2), new Point(3, -2));
        equilateralTriangle = new Triangle(new Point(0, 0), new Point(3, 0), new Point(1.5, 2.598));
        analyzer = new TriangleAnalyzer();
    }

    @Test
    public void getTriangleAngleType_ParameterObtuseTriangle_ShouldReturnObtuse() {
        TriangleAnalyzer.TriangleAngleType expected = TriangleAnalyzer.TriangleAngleType.OBTUSE;
        TriangleAnalyzer.TriangleAngleType actual = analyzer.getTriangleAngleType(obtuseAndIsoscelesTriangle);
        Assert.assertEquals(actual, expected, "Must be obtuse.");
    }

    @Test
    public void getTriangleAngleType_ParameterAcuteTriangle_ShouldReturnAcute() {
        TriangleAnalyzer.TriangleAngleType expected = TriangleAnalyzer.TriangleAngleType.ACUTE;
        TriangleAnalyzer.TriangleAngleType actual = analyzer.getTriangleAngleType(acuteAndScaleneTriangle);
        Assert.assertEquals(actual, expected, "Must be acute.");
    }

    @Test
    public void getTriangleAngleType_ParameterRightTriangle_ShouldReturnRight() {
        TriangleAnalyzer.TriangleAngleType expected = TriangleAnalyzer.TriangleAngleType.RIGHT;
        TriangleAnalyzer.TriangleAngleType actual = analyzer.getTriangleAngleType(rightAndScaleneTriangle);
        Assert.assertEquals(actual, expected, "Must be right.");
    }

    @Test
    public void getTriangleSideType_ParameterScaleneTriangle_ShouldReturnScalene() {
        TriangleAnalyzer.TriangleSideType expected = TriangleAnalyzer.TriangleSideType.SCALENE;
        TriangleAnalyzer.TriangleSideType actual = analyzer.getTriangleSideType(rightAndScaleneTriangle);
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void getTriangleSideType_ParameterIsoscelesTriangle_ShouldReturnIsosceles() {
        TriangleAnalyzer.TriangleSideType expected = TriangleAnalyzer.TriangleSideType.ISOSCELES;
        TriangleAnalyzer.TriangleSideType actual = analyzer.getTriangleSideType(obtuseAndIsoscelesTriangle);
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void getTriangleSideType_ParameterEquilateralTriangle_ShouldReturnEquilateral() {
        TriangleAnalyzer.TriangleSideType expected = TriangleAnalyzer.TriangleSideType.EQUILATERAL;
        TriangleAnalyzer.TriangleSideType actual = analyzer.getTriangleSideType(equilateralTriangle);
        Assert.assertEquals(actual, expected);
    }


    @Test
    public void getTriangleSquare_ParameterTriangleWithSquare8_ShouldReturn8() {
        double expectedValue = 8;
        double actualValue = analyzer.getTriangleSquare(triangle);
        Assert.assertEquals(actualValue, expectedValue, "Must be " + expectedValue + " but is : " + actualValue);
    }

    @Test
    public void getTrianglePerimeter_ParameterTriangleWithPerimeter13_66_ShouldReturn13_66() {
        double expectedValue = 13.66;
        double actualValue = analyzer.getTrianglePerimeter(triangle);
        Assert.assertEquals(actualValue, 13.66, "Must be " + expectedValue + "but is: " + actualValue);
    }
}
