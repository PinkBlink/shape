package org.triangle;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.triangle.exception.NoFileException;
import org.triangle.utils.ReaderFromFile;

import java.util.List;

public class ReaderFromFileTest {
    private String validPath;
    private String invalidPath;
    private ReaderFromFile readerFromFile;

    @BeforeTest
    public void setUp() {
        readerFromFile = new ReaderFromFile();
        invalidPath = "files/wrong.txt";
        validPath = "data/data.txt";
    }

    @Test
    public void getAllValidCoordinates_ParameterInvalidPath_ShouldThrowNoFileException() {
        Assert.assertThrows(NoFileException.class, () -> {
            readerFromFile.getAllValidCoordinates(invalidPath);
        });
    }

    @Test
    public void getAllValidCoordinates_ParameterValidPath_ShouldReturnListStringWithCoordinates() {
        try {
            List<String> result = readerFromFile.getAllValidCoordinates(validPath);
            Assert.assertNotNull(result);
        } catch (NoFileException e) {
            throw new RuntimeException(e);
        }
    }
}
