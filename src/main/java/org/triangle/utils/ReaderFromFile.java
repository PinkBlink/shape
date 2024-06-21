package org.triangle.utils;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.triangle.exception.NoFileException;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;


public class ReaderFromFile {
    private final Logger logger = LogManager.getLogger(ReaderFromFile.class);

    private static final String PATH_TO_DATA = "data/data.txt";

    public List<String> getAllValidCoordinates(String path) throws NoFileException {
//        List<String> result = new ArrayList<>();
//        try {
//        FileReader reader = new FileReader(PATH_TO_DATA);
//        Scanner scanner = new Scanner(reader);
//            while (scanner.hasNextLine()) {
//                String coordinates = scanner.nextLine();
//                if (Inspector.isValidCoordinatesString(coordinates)) {
//                    result.add(coordinates);
//                }
//            }
//            scanner.close();
//        } catch (IOException e) {
//            throw new NoFileException();
//        }
//        return result;

        // It is good solve for this method?
        try {
            return Files.readAllLines(Path.of(path)).stream().filter(line -> {
                        if (Inspector.isValidCoordinatesString(line)) {
                            logger.log(Level.INFO, "Valid coordinates received <" + line + "> from file :" + path);
                            return true;
                        } else {
                            logger.log(Level.ERROR, "Invalid coordinates: " + line);
                            return false;
                        }
                    })
                    .collect(Collectors.toList());
        } catch (IOException e) {
            throw new NoFileException();
        }
    }

    public List<String> getAllValidCoordinates() throws NoFileException {
        return getAllValidCoordinates(PATH_TO_DATA);
    }
}
