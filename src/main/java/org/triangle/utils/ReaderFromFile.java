package org.triangle.utils;

import org.triangle.exception.NoFileException;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;


public class ReaderFromFile {
    private static final String PATH_TO_DATA = "data/data.txt";

    public List<String> getAllValidCoordinates() throws NoFileException {
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
            return Files.readAllLines(Path.of(PATH_TO_DATA)).stream().filter(Inspector::isValidCoordinatesString)
                    .collect(Collectors.toList());
        } catch (IOException e) {
            throw new NoFileException();
        }
    }
}
