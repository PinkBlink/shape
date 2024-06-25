package org.triangle.utils;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class DoubleUtils {
    private static final int COUNT_OF_DIGITS = 2;

    public static double roundToTwoDecimalPlaces(double value) {
        BigDecimal bigDecimalValue = BigDecimal.valueOf(value);
        bigDecimalValue = bigDecimalValue.setScale(COUNT_OF_DIGITS, RoundingMode.HALF_UP);
        return bigDecimalValue.doubleValue();
    }

    public static int hashDouble(double d) {
        long longDouble = Double.doubleToLongBits(d);
        return (int) (longDouble ^ (longDouble >>> 32));
    }
}
