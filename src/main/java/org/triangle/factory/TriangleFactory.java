package org.triangle.factory;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.triangle.entity.Point;
import org.triangle.entity.Triangle;
import org.triangle.utils.TriangleValidator;

import java.util.List;


public class TriangleFactory {
    public static final Logger logger = LogManager.getLogger(TriangleFactory.class);
    private final PointFactory pointFactory = new PointFactory();

    public Triangle getTriangle(Point a, Point b, Point c) {
        TriangleValidator.throwExceptionIfInvalidTriangle(a, b, c);
        Triangle triangle = new Triangle(a, b, c);
        logger.log(Level.INFO, "Triangle " + triangle + " created successfully");
        return triangle;
    }

    public Triangle getTriangle(String coordinates) {
        List<Point> points = pointFactory.getPointListFromString(coordinates);
        Point firstPoint = points.get(0);
        Point secondPoint = points.get(1);
        Point thirdPoint = points.get(2);
        return getTriangle(firstPoint, secondPoint, thirdPoint);
    }
}
