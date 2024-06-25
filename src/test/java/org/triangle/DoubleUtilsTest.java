package org.triangle;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.triangle.utils.DoubleUtils;

public class DoubleUtilsTest {
    private int hashFromDouble;
    private double doubleForHashing;
    private double largeDouble;

    @BeforeTest
    public void setUp() {
        hashFromDouble = -644349949;
        doubleForHashing = 2.2;
        largeDouble = 2.2222222222222;
    }

    @Test
    public void hashDoubleWithDoubleForHashingShouldReturnHashFromDoubleTest() {
        int actual = DoubleUtils.hashDouble(doubleForHashing);
        Assert.assertEquals(actual, hashFromDouble);
    }
    @Test
    public void roundToTwoDecimalPlacesWithLargeDoubleShouldReturnSameDoubleWithTwoDigitsAfterPointTest(){
        double expected = 2.22;
        double actual = DoubleUtils.roundToTwoDecimalPlaces(largeDouble);
        Assert.assertEquals(actual,expected);
    }
}
