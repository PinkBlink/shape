package org.triangle;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.triangle.entity.Point;
import org.triangle.factory.PointFactory;

import java.util.Arrays;
import java.util.List;

public class PointFactoryTest {
    private PointFactory pointFactory;
    private String coordinates;

    @BeforeTest
    public void setUp() {
        pointFactory = new PointFactory();
        coordinates = "0.0 0.0 0.0 0.0 0.0 0.0";
    }

    @Test
    public void getPointShouldCreatePointTest() {
        Point actual = pointFactory.getPoint(0, 0);
        Point expected = new Point(0, 0);
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void getPointListFromStringIfValidCoordinatesShouldReturnPointListTest() {
        List<Point> expected = Arrays.asList(new Point(0, 0), new Point(0, 0), new Point(0, 0));
        List<Point> actual = pointFactory.getPointListFromString(coordinates);
        Assert.assertEquals(actual, expected);
    }
}
