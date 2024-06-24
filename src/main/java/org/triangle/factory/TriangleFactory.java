package org.triangle.factory;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.triangle.entity.Point;
import org.triangle.entity.Triangle;
import org.triangle.exception.CollinearPointsException;
import org.triangle.utils.Inspector;

import java.util.List;


public class TriangleFactory {
    public static final Logger logger = LogManager.getLogger(TriangleFactory.class);
    private final PointFactory pointFactory = new PointFactory();

    public Triangle getTriangle(Point a, Point b, Point c) {
        if (Inspector.isValidTriangle(a, b, c)) {
            Triangle t = new Triangle(a, b, c);
            logger.log(Level.INFO, "Triangle " + t + " created successfully");
            return t;
        } else {
            logger.log(Level.ERROR, "Attempt to create a wrong triangle stopped");
            throw new CollinearPointsException();
        }
    }

    public Triangle getTriangle(String coordinates) {
        List<Point> points = pointFactory.getPointListFromString(coordinates);
        Point firstPoint = points.get(0);
        Point secondPoint = points.get(1);
        Point thirdPoint = points.get(2);
        return getTriangle(firstPoint, secondPoint, thirdPoint);
    }
}
