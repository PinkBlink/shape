package org.triangle.entity;

public class Point {
    private final double xCoordinate;
    private final double yCoordinate;

    public Point(double xCoordinate, double yCoordinate) {
        this.xCoordinate = xCoordinate;
        this.yCoordinate = yCoordinate;
    }

    public double getXCoordinate() {
        return xCoordinate;
    }

    public double getYCoordinate() {
        return yCoordinate;
    }

    @Override
    public String toString() {
        return "Point{" +
                "x coordinate =" + xCoordinate +
                ", y coordinate =" + yCoordinate +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Point point = (Point) o;
        return Double.compare(xCoordinate, point.xCoordinate) == 0
                && Double.compare(yCoordinate, point.yCoordinate) == 0;
    }

    @Override
    public int hashCode() {
        int total = 31;
        long longX = Double.doubleToLongBits(xCoordinate);
        long longY = Double.doubleToLongBits(yCoordinate);
        total = total * 31 + (int) (longX ^ (longX >>> 32)) + (int) (longY ^ (longY >>> 32));
        return total;
    }
}
