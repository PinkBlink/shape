package org.triangle;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.triangle.utils.Inspector;
import org.triangle.utils.UtilsForDouble;

public class ReaderFromFileTest {
    String wrongCoordinates;
    String validCoordinates;

    @BeforeTest
    public void setUp(){
        wrongCoordinates = "1.0 0.0 0.0 1.0 0.0 1.2 ";
        validCoordinates = "1.0 0.0 0.0 1.0 0.0 1.2";
    }
    @Test
    public void isValidCoordinatesNegativeTest(){
        Assert.assertFalse(Inspector.isValidCoordinatesString(wrongCoordinates));
    }
    @Test
    public void isValidCoordinatesPositiveTest(){
        Assert.assertTrue(Inspector.isValidCoordinatesString(validCoordinates));
    }
}
