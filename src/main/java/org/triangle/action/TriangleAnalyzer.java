package org.triangle.action;

import org.triangle.entity.Triangle;
import org.triangle.utils.UtilsForDouble;


public class TriangleAnalyzer {

    public double getTrianglePerimeter(Triangle t) {
        return UtilsForDouble.roundToTwoDecimalPlaces(t.getFirstSide() + t.getSecondSide() + t.getThirdSide());
    }

    public double getTriangleSquare(Triangle t) {
        double semiPerimeter = getTrianglePerimeter(t) / 2;
        double square = Math.sqrt(semiPerimeter * (semiPerimeter - t.getFirstSide()) *
                (semiPerimeter - t.getSecondSide()) * (semiPerimeter - t.getThirdSide()));
        return UtilsForDouble.roundToTwoDecimalPlaces(square);
    }
}
