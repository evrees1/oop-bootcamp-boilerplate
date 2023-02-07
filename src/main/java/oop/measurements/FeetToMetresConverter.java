package oop.measurements;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class FeetToMetresConverter {

    private final int SCALE = 4;
    private final BigDecimal divisor = BigDecimal.valueOf(3.281);

    public BigDecimal convert(int feet) {
        return BigDecimal.valueOf(feet)
                .divide(divisor, SCALE, RoundingMode.HALF_UP);
    }
}
