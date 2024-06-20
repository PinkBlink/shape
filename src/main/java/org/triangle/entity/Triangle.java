package org.triangle.entity;

import org.triangle.utils.UtilsForDouble;

public class Triangle {
    private final Point a;
    private final Point b;
    private final Point c;
    private double firstSide;
    private double secondSide;
    private double thirdSide;
    private double firstAngle;
    private double secondAngle;
    private double thirdAngle;

    public Triangle(Point a, Point b, Point c) {
        this.a = a;
        this.b = b;
        this.c = c;
        calculateCharacteristicsOfTriangle();
    }

    public Point getA() {
        return a;
    }

    public Point getB() {
        return b;
    }

    public Point getC() {
        return c;
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

    public double calculateSide(Point a, Point b) {
        double side = Math.sqrt(Math.pow(b.getX() - a.getX(), 2) + Math.pow(b.getY() - a.getY(), 2));
        return UtilsForDouble.roundToTwoDecimalPlaces(side);
    }

    public double calculateAngle(double firstSide, double secondSide, double thirdSide) {
        return Math.toDegrees(Math.acos((secondSide * secondSide + thirdSide * thirdSide - firstSide * firstSide) /
                (2 * secondSide * thirdSide)));
    }

    public boolean isRightTriangle() {
        int rightAngle = 90;
        return (int) (firstAngle) == rightAngle || (int) (secondAngle) == rightAngle || (int) (thirdAngle) == rightAngle;
    }

    private void calculateCharacteristicsOfTriangle() {
        this.firstSide = calculateSide(a, b);
        this.secondSide = calculateSide(b, c);
        this.thirdSide = calculateSide(c, a);
        this.firstAngle = calculateAngle(firstSide, secondSide, thirdSide);
        this.secondAngle = calculateAngle(secondSide, thirdSide, firstSide);
        this.thirdAngle = calculateAngle(thirdSide, firstSide, secondSide);
    }


    @Override
    public String toString() {
        return "Triangle{" +
                "a=" + a +
                ", b=" + b +
                ", c=" + c +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Triangle triangle = (Triangle) o;
        return a.equals(triangle.a) && b.equals(triangle.b) && c.equals(triangle.c);
    }

    @Override
    public int hashCode() {
        int total = 31;
        total = total * 31 + a.hashCode();
        total = total * 31 + b.hashCode();
        total = total * 31 + c.hashCode();
        total = total * 31 + UtilsForDouble.hashDouble(firstSide);
        total = total * 31 + UtilsForDouble.hashDouble(secondSide);
        total = total * 31 + UtilsForDouble.hashDouble(thirdSide);
        total = total * 31 + UtilsForDouble.hashDouble(firstAngle);
        total = total * 31 + UtilsForDouble.hashDouble(secondAngle);
        total = total * 31 + UtilsForDouble.hashDouble(thirdAngle);
        return total;
    }
}
