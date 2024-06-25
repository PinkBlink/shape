package org.triangle.utils;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.triangle.entity.Triangle;
import org.triangle.exception.NoFileException;

import javax.xml.validation.Validator;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;

public class CoordinatesFileReader {
    private static final Logger logger = LogManager.getLogger(CoordinatesFileReader.class);

    private static final String PATH_TO_DATA = "data/data.txt";

    public List<String> getAllValidCoordinates(Path path) throws NoFileException {
        try {
            return Files.readAllLines(path).stream().
                    filter(TriangleValidator::isValidCoordinatesString)
                    .collect(Collectors.toList());
        } catch (IOException e) {
            logger.log(Level.ERROR, "The file may not exist");
            throw new NoFileException();
        }
    }

    public List<String> getAllValidCoordinates() throws NoFileException {
        Path path = Path.of(PATH_TO_DATA);
        return getAllValidCoordinates(path);
    }
}
