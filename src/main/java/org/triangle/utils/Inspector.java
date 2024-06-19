package org.triangle.utils;

import org.triangle.entity.Point;
import org.triangle.entity.Triangle;

import java.util.regex.Pattern;

public class Inspector {
    private static final String STRING_COORDINATES_FORMAT_REGEX = "^(-?\\d\\.\\d ){5}-?\\d\\.\\d$";
    public static boolean isValidCoordinatesString(String s){
        return Pattern.matches(STRING_COORDINATES_FORMAT_REGEX,s);
    }
    public static boolean isValidTriangle(Triangle t) {
        Point a = t.getA();
        Point b = t.getB();
        Point c = t.getC();

        if(a.equals(b) || b.equals(c) || c.equals(a)){
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
