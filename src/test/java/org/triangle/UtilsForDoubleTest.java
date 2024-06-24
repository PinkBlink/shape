package org.triangle;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.triangle.utils.UtilsForDouble;

public class UtilsForDoubleTest {
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
    public void hashDouble_ParameterDoubleForHashing_ShouldReturnHashFromDouble() {
        int actual = UtilsForDouble.hashDouble(doubleForHashing);
        Assert.assertEquals(actual, hashFromDouble);
    }
    @Test
    public void roundToTwoDecimalPlaces_ParameterLargeDouble_ShouldReturnSameDoubleWithTwoDigitsAfterPoint(){
        double expected = 2.22;
        double actual = UtilsForDouble.roundToTwoDecimalPlaces(largeDouble);
        Assert.assertEquals(actual,expected);
    }
}
