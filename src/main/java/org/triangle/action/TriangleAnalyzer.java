package org.triangle.action;

import org.triangle.entity.Triangle;
import org.triangle.utils.DoubleUtils;


public class TriangleAnalyzer {
    private static final double RIGHT_ANGLE = 90;
    private static final double HALF = 2;

    public double getTrianglePerimeter(Triangle triangle) {
        double firstSide = triangle.getFirstSide();
        double secondSide = triangle.getSecondSide();
        double thirdSide = triangle.getThirdSide();
        return DoubleUtils.roundToTwoDecimalPlaces(firstSide + thirdSide + secondSide);
    }

    public double getTriangleSquare(Triangle triangle) {
        double semiPerimeter = getTrianglePerimeter(triangle) / HALF;
        double square = Math.sqrt(semiPerimeter * (semiPerimeter - triangle.getFirstSide()) *
                (semiPerimeter - triangle.getSecondSide()) * (semiPerimeter - triangle.getThirdSide()));
        return DoubleUtils.roundToTwoDecimalPlaces(square);
    }

    public TriangleAngleType getTriangleAngleType(Triangle triangle) {
        double firstAngle = triangle.getFirstAngle();
        double secondAngle = triangle.getSecondAngle();
        double thirdAngle = triangle.getThirdAngle();

        if (isAcuteTriangle(firstAngle, secondAngle, thirdAngle)) {
            return TriangleAngleType.ACUTE;
        } else if (isObtuseTriangle(firstAngle, secondAngle, thirdAngle)) {
            return TriangleAngleType.OBTUSE;
        } else {
            return TriangleAngleType.RIGHT;
        }
    }

    public TriangleSideType getTriangleSideType(Triangle triangle) {
        double firstSide = triangle.getFirstSide();
        double secondSide = triangle.getSecondSide();
        double thirdSide = triangle.getThirdSide();

        if (isEquilateralTriangle(firstSide, secondSide, thirdSide)) {
            return TriangleSideType.EQUILATERAL;
        } else if (isIsoscelesTriangle(firstSide, secondSide, thirdSide)) {
            return TriangleSideType.ISOSCELES;
        } else {
            return TriangleSideType.SCALENE;
        }
    }

    private boolean isIsoscelesTriangle(double firstSide, double secondSide, double thirdSide) {
        return firstSide == secondSide
                || secondSide == thirdSide
                || thirdSide == firstSide;
    }

    private boolean isEquilateralTriangle(double firstSide, double secondSide, double thirdSide) {
        return firstSide == secondSide
                && secondSide == thirdSide;
    }

    private boolean isAcuteTriangle(double firstAngle, double secondAngle, double thirdAngle) {
        return firstAngle < RIGHT_ANGLE
                && secondAngle < RIGHT_ANGLE
                && thirdAngle < RIGHT_ANGLE;
    }

    private boolean isObtuseTriangle(double firstAngle, double secondAngle, double thirdAngle) {

        return firstAngle > RIGHT_ANGLE
                || secondAngle > RIGHT_ANGLE
                || thirdAngle > RIGHT_ANGLE;
    }

    public enum TriangleAngleType {
        RIGHT,
        ACUTE,
        OBTUSE
    }

    public enum TriangleSideType {
        ISOSCELES,
        EQUILATERAL,
        SCALENE
    }
}