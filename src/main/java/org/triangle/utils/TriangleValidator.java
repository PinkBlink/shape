package org.triangle.utils;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.triangle.entity.Point;
import org.triangle.exception.CollinearPointsException;
import org.triangle.factory.PointFactory;

import java.util.List;
import java.util.regex.Pattern;

public class TriangleValidator {
    public static final Logger logger = LogManager.getLogger(TriangleValidator.class);

    private static final String STRING_COORDINATES_FORMAT_REGEX = "^(-?\\d+\\.\\d+ ){5}-?\\d+\\.\\d+$";

    public static boolean isValidCoordinatesString(String string) {
        if (Pattern.matches(STRING_COORDINATES_FORMAT_REGEX, string)) {
            List<Point> points = new PointFactory().getPointListFromString(string);

            if (isPossibleTriangle(points.get(0), points.get(1), points.get(2))) {
                logger.log(Level.INFO, "Valid coordinates received <" + string + "> from file");
                return true;
            }
        }
        logger.log(Level.ERROR, "Invalid coordinates: " + string);
        return false;
    }

    public static boolean isPossibleTriangle(Point a, Point b, Point c) {
        if (a.equals(b)
                || b.equals(c)
                || c.equals(a)) {
            return false;
        }
        double aX = a.getXCoordinate();
        double aY = a.getYCoordinate();
        double bX = b.getXCoordinate();
        double bY = b.getYCoordinate();
        double cX = c.getXCoordinate();
        double cY = c.getYCoordinate();

        return (aX * (bY - cY) + bX * (cY - aY) + cX * (aY - bY)) != 0;
    }

    public static void throwExceptionIfInvalidTriangle(Point a, Point b, Point c) {
        if (!isPossibleTriangle(a, b, c)) {
            logger.log(Level.ERROR, "Attempt to create a wrong triangle stopped");
            throw new CollinearPointsException();
        }
    }
}
