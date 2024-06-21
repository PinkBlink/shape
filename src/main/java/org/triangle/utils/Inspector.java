package org.triangle.utils;

import org.triangle.entity.Point;
import org.triangle.factory.PointFactory;

import java.util.List;
import java.util.regex.Pattern;

public class Inspector {
    private static final String STRING_COORDINATES_FORMAT_REGEX = "^(-?\\d+\\.\\d+ ){5}-?\\d+\\.\\d+$";

    public static boolean isValidCoordinatesString(String s) {
        if (Pattern.matches(STRING_COORDINATES_FORMAT_REGEX, s)) {
            List<Point> points = new PointFactory().getPointListFromString(s);
            return isValidTriangle(points.get(0), points.get(1), points.get(2));
        }
        return false;
    }

    public static boolean isValidTriangle(Point a, Point b, Point c) {
        if (a.equals(b) || b.equals(c) || c.equals(a)) {
            return false;
        }
        double aX = a.getX();
        double aY = a.getY();
        double bX = b.getX();
        double bY = b.getY();
        double cX = c.getX();
        double cY = c.getY();

        return (aX * (bY - cY) + bX * (cY - aY) + cX * (aY - bY)) != 0;
    }
}
