package org.triangle.factory;

import org.triangle.entity.Point;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class PointFactory {
    private static final String SPACE_REGEX = "\\s";

    public Point getPoint(double x, double y) {
        return new Point(x, y);
    }

    public List<Point> getPointListFromString(String coordinates) {
        List<String> coordinatesList = Arrays.stream(coordinates.split(SPACE_REGEX)).collect(Collectors.toList());
        List<Point> result = new ArrayList<>();
        for (int i = 0; i < coordinatesList.size(); i += 2) {
            String xString = coordinatesList.get(i);
            String yString = coordinatesList.get(i + 1);
            double x = Double.parseDouble(xString);
            double y = Double.parseDouble(yString);
            result.add(getPoint(x, y));
        }
        return result;
    }
}
