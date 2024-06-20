package org.triangle;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.triangle.entity.Point;
import org.triangle.entity.Triangle;
import org.triangle.exception.CollinearPointsException;
import org.triangle.factory.TriangleFactory;

public class TriangleFactoryTest {
    TriangleFactory factory = new TriangleFactory();

    @Test
    public void samePointFactoryThrowTest() {
        Point samePoint = new Point(0, 0);
        Assert.assertThrows(CollinearPointsException.class, () -> {
            factory.getTriangle(samePoint, samePoint, samePoint);
        });
    }

    @Test
    public void oneLinePointsFactoryThrowTest() {
        Point firstPoint = new Point(1, 1);
        Point secondPoint = new Point(2, 2);
        Point thirdPoint = new Point(3, 3);

        Assert.assertThrows(CollinearPointsException.class, () -> {
            factory.getTriangle(firstPoint, secondPoint, thirdPoint);
        });
    }

    @Test
    public void positiveCaseFactoryTest() {
        Point firstPoint = new Point(0, 1);
        Point secondPoint = new Point(2, 2);
        Point thirdPoint = new Point(3, -1);

        Assert.assertEquals(Triangle.class, factory.getTriangle(firstPoint, secondPoint, thirdPoint).getClass());
    }
}
