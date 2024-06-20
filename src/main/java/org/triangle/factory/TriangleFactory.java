package org.triangle.factory;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.triangle.entity.Point;
import org.triangle.entity.Triangle;
import org.triangle.exception.CollinearPointsException;
import org.triangle.utils.Inspector;


public class TriangleFactory {
    public static Logger logger = LogManager.getLogger(TriangleFactory.class);
    public Triangle getTriangle(Point a, Point b, Point c) {
        Triangle t = new Triangle(a, b, c);
        if (Inspector.isValidTriangle(t)) {
            logger.log(Level.INFO,"Triangle created successfully");
            return t;
        } else {
            logger.log(Level.WARN,"Attempt to create a warning triangle stopped");
            throw new CollinearPointsException();
        }
    }
}
