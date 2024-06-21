package org.triangle.action;

import org.triangle.entity.Triangle;
import org.triangle.utils.UtilsForDouble;


public class TriangleAnalyzer {
    private static final double RIGHT_ANGLE = 90;

    public double getTrianglePerimeter(Triangle t) {
        return UtilsForDouble.roundToTwoDecimalPlaces(t.getFirstSide() + t.getSecondSide() + t.getThirdSide());
    }

    public double getTriangleSquare(Triangle t) {
        double semiPerimeter = getTrianglePerimeter(t) / 2;
        double square = Math.sqrt(semiPerimeter * (semiPerimeter - t.getFirstSide()) *
                (semiPerimeter - t.getSecondSide()) * (semiPerimeter - t.getThirdSide()));
        return UtilsForDouble.roundToTwoDecimalPlaces(square);
    }

    public TriangleAngleType getTriangleAngleType(Triangle t) {
        if (isAcuteTriangle(t)) {
            return TriangleAngleType.ACUTE;
        } else if (isObtuseTriangle(t)) {
            return TriangleAngleType.OBTUSE;
        } else {
            return TriangleAngleType.RIGHT;
        }
    }

    public TriangleSideType getTriangleSideType(Triangle t) {
        if (isEquilateralTriangle(t)) {
            return TriangleSideType.EQUILATERAL;
        } else if (isIsoscelesTriangle(t)) {
            return TriangleSideType.ISOSCELES;
        } else {
            return TriangleSideType.SCALENE;
        }
    }

    private boolean isIsoscelesTriangle(Triangle t) {
        double firstSide = t.getFirstSide();
        double secondSide = t.getSecondSide();
        double thirdSide = t.getThirdSide();
        return firstSide == secondSide || secondSide == thirdSide || thirdSide == firstSide;
    }

    private boolean isEquilateralTriangle(Triangle t) {
        double firstSide = t.getFirstSide();
        double secondSide = t.getSecondSide();
        double thirdSide = t.getThirdSide();
        return firstSide == secondSide && secondSide == thirdSide;
    }

    private boolean isAcuteTriangle(Triangle t) {
        double firstAngle = t.getFirstAngle();
        double secondAngle = t.getSecondAngle();
        double thirdAngle = t.getThirdAngle();
        return firstAngle < RIGHT_ANGLE && secondAngle < RIGHT_ANGLE && thirdAngle < RIGHT_ANGLE;
    }

    private boolean isObtuseTriangle(Triangle t) {
        double firstAngle = t.getFirstAngle();
        double secondAngle = t.getSecondAngle();
        double thirdAngle = t.getThirdAngle();
        return firstAngle > RIGHT_ANGLE || secondAngle > RIGHT_ANGLE || thirdAngle > RIGHT_ANGLE;
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
