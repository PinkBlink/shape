package org.triangle;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.triangle.exception.NoFileException;
import org.triangle.utils.CoordinatesFileReader;

import java.nio.file.Path;
import java.util.List;

public class CoordinatesFileReaderTest {
    private String validPathString;
    private String invalidPathString;
    private Path validPath;
    private Path invalidPath;
    private CoordinatesFileReader readerFromFile;

    @BeforeTest
    public void setUp() {
        readerFromFile = new CoordinatesFileReader();
        invalidPathString = "files/wrong.txt";
        validPathString = "data/data.txt";
        invalidPath = Path.of(invalidPathString);
        validPath = Path.of(validPathString);
    }

    @Test
    public void getAllValidCoordinatesIfInvalidPathShouldThrowNoFileExceptionTest() {
        Assert.assertThrows(NoFileException.class, () -> {
            readerFromFile.getAllValidCoordinates(invalidPath);
        });
    }

    @Test
    public void getAllValidCoordinatesIfValidPathShouldReturnListStringWithCoordinatesTest() {
        try {
            List<String> result = readerFromFile.getAllValidCoordinates(validPath);
            Assert.assertNotNull(result);
        } catch (NoFileException e) {
            throw new RuntimeException(e);
        }
    }
}
