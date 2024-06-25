package org.triangle.app;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.triangle.action.TriangleAnalyzer;
import org.triangle.entity.Triangle;
import org.triangle.exception.NoFileException;
import org.triangle.factory.TriangleFactory;
import org.triangle.utils.CoordinatesFileReader;

import java.util.ArrayList;
import java.util.List;

public class EntryPoint {
    private static final Logger logger = LogManager.getLogger(EntryPoint.class);

    public static void main(String[] args) {
        TriangleAnalyzer triangleAnalyzer = new TriangleAnalyzer();
        TriangleFactory triangleFactory = new TriangleFactory();
        CoordinatesFileReader readerFromFile = new CoordinatesFileReader();

        List<String> coordinates;
        List<Triangle> trianglesFromFile = new ArrayList<>();

        try {
            coordinates = readerFromFile.getAllValidCoordinates();
            for (String s : coordinates) {
                Triangle triangle = triangleFactory.getTriangle(s);
                trianglesFromFile.add(triangle);
            }
            for (Triangle t : trianglesFromFile) {
                logger.log(Level.INFO, t + ":\n");
                logger.log(Level.INFO, "----> angle type = " + triangleAnalyzer.getTriangleAngleType(t));
                logger.log(Level.INFO, "----> side type = " + triangleAnalyzer.getTriangleSideType(t));
                logger.log(Level.INFO, "----> perimeter = " + triangleAnalyzer.getTrianglePerimeter(t));
                logger.log(Level.INFO, "----> square = " + triangleAnalyzer.getTriangleSquare(t));
                logger.log(Level.INFO, "----> first side =" + t.getFirstSide());
                logger.log(Level.INFO, "----> second side =" + t.getSecondSide());
                logger.log(Level.INFO, "----> third side =" + t.getThirdSide());
                logger.log(Level.INFO, "----> first angle  =" + t.getFirstAngle());
                logger.log(Level.INFO, "----> second angle  =" + t.getSecondAngle());
                logger.log(Level.INFO, "----> third angle  =" + t.getThirdAngle());
                logger.log(Level.INFO, "____________________________________-");
            }
        } catch (NoFileException e) {
            logger.log(Level.ERROR, e.getMessage());
        }
    }
}
