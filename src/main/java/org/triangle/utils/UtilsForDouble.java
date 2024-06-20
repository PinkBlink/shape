package org.triangle.utils;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class UtilsForDouble {
    public static double roundToTwoDecimalPlaces(double value) {
        BigDecimal bd = BigDecimal.valueOf(value);
        bd = bd.setScale(2, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }
    public static int hashDouble(double d) {
        long longDouble = Double.doubleToLongBits(d);
        return (int) (longDouble ^ (longDouble >>> 32));
    }
}
