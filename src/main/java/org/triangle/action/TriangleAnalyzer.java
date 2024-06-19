package org.triangle.action;

import org.triangle.entity.Point;
import org.triangle.entity.Triangle;
import org.triangle.utils.Inspector;
import org.triangle.exception.CollinearPointsException;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class TriangleAnalyzer {
    private final Triangle triangle;
    private final double firstSide;
    private final double secondSide;
    private final double thirdSide;
    private final double firstAngle;
    private final double secondAngle;
    private final double thirdAngle;
    public TriangleAnalyzer(Triangle triangle) {
        if (Inspector.isValidTriangle(triangle)) {
            this.triangle = triangle;
            this.firstSide = calculateSide(triangle.getA(), triangle.getB());
            this.secondSide = calculateSide(triangle.getB(), triangle.getC());
            this.thirdSide = calculateSide(triangle.getC(), triangle.getA());
            this.firstAngle = calculateAngle(firstSide, secondSide, thirdSide);
            this.secondAngle = calculateAngle(secondSide, thirdSide, firstSide);
            this.thirdAngle = calculateAngle(thirdSide, firstSide, secondSide);
        } else {
            throw new CollinearPointsException();
        }
    }

    public Triangle getTriangle() {
        return triangle;
    }

    public double getFirstSide() {
        return firstSide;
    }

    public double getSecondSide() {
        return secondSide;
    }

    public double getThirdSide() {
        return thirdSide;
    }

    public double getFirstAngle() {
        return firstAngle;
    }

    public double getSecondAngle() {
        return secondAngle;
    }

    public double getThirdAngle() {
        return thirdAngle;
    }

    public boolean isRightTriangle() {
        int rightAngle = 90;
        return (int) (firstAngle) == 90 || (int) (secondAngle) == 90 || (int) (thirdAngle) == 90;
    }

    public double calculateSide(Point a, Point b) {
        double side = Math.sqrt(Math.pow(b.getX() - a.getX(), 2) + Math.pow(b.getY() - a.getY(), 2));
        return roundToTwoDecimalPlaces(side);
    }

    public double calculateAngle(double firstSide, double secondSide, double thirdSide) {
        return Math.toDegrees(Math.acos((secondSide * secondSide + thirdSide * thirdSide - firstSide * firstSide) /
                (2 * secondSide * thirdSide)));
    }

    public double getTrianglePerimeter() {

        return roundToTwoDecimalPlaces(firstSide + secondSide + thirdSide);
    }

    public double getTriangleSquare() {
        double semiPerimeter = getTrianglePerimeter() / 2;
        double square = Math.sqrt(semiPerimeter * (semiPerimeter - firstSide) * (semiPerimeter - secondSide)
                * (semiPerimeter - thirdSide));
        return roundToTwoDecimalPlaces(square);
    }

    private double roundToTwoDecimalPlaces(double value) {
        BigDecimal bd = BigDecimal.valueOf(value);
        bd = bd.setScale(2, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }

    @Override
    public String toString() {
        return "main.entity.TriangleAnalyzer{" +
                "triangle=" + triangle +
                ", firstSide=" + firstSide +
                ", secondSide=" + secondSide +
                ", thirdSide=" + thirdSide +
                ", firstAngle=" + firstAngle +
                ", secondAngle=" + secondAngle +
                ", thirdAngle=" + thirdAngle +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TriangleAnalyzer that = (TriangleAnalyzer) o;
        return Double.compare(firstSide, that.firstSide) == 0 && Double.compare(secondSide, that.secondSide) == 0
                && Double.compare(thirdSide, that.thirdSide) == 0 && Double.compare(firstAngle, that.firstAngle) == 0
                && Double.compare(secondAngle, that.secondAngle) == 0 && Double.compare(thirdAngle, that.thirdAngle) == 0
                && triangle.equals(that.triangle);
    }

    @Override
    public int hashCode() {
        int total = 31;
        total = total * 31 + (triangle == null ? 0 : triangle.hashCode());
        total = total * 31 + hashDouble(firstSide);
        total = total * 31 + hashDouble(secondSide);
        total = total * 31 + hashDouble(thirdSide);
        total = total * 31 + hashDouble(firstAngle);
        total = total * 31 + hashDouble(secondAngle);
        total = total * 31 + hashDouble(thirdAngle);
        return total;
    }

    private int hashDouble(double d) {
        long longDouble = Double.doubleToLongBits(d);
        return (int) (longDouble ^ (longDouble >>> 32));
    }
}
