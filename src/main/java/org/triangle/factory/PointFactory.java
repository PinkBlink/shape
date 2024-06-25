package org.triangle.factory;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.triangle.entity.Point;

import java.time.Year;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class PointFactory {
    private static final String SPACE_REGEX = "\\s";
    private static final Logger logger = LogManager.getLogger(PointFactory.class);

    public Point getPoint(double xCoordinate, double yCoordinate) {
        Point point = new Point(xCoordinate, yCoordinate);
        logger.log(Level.INFO, "Point created successfully: " + point);
        return point;
    }

    public List<Point> getPointListFromString(String coordinates) {
        List<String> coordinatesList = Arrays.stream(coordinates.split(SPACE_REGEX))
                .collect(Collectors.toList());
        List<Point> result = new ArrayList<>();

        for (int i = 0; i < coordinatesList.size(); i += 2) {
            String xString = coordinatesList.get(i);
            String yString = coordinatesList.get(getNextIndex(i));
            double x = Double.parseDouble(xString);
            double y = Double.parseDouble(yString);
            result.add(getPoint(x, y));
        }
        return result;
    }

    private int getNextIndex(int index) {
        return index + 1;
    }
}
