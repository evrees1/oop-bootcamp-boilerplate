package oop.measurements;

import java.math.BigDecimal;
import java.math.RoundingMode;

public abstract class MeasurementConvertor {

    private final int SCALE = 4;

    public abstract BigDecimal convert(double value);
//    {
//        return BigDecimal.valueOf(value)
//                .divide(factor(), SCALE, RoundingMode.HALF_UP);
//    }

    protected BigDecimal divide(double value) {
        return BigDecimal.valueOf(value)
                .divide(factor(), SCALE, RoundingMode.HALF_UP);
    }

    protected BigDecimal multiply(double value) {
        return BigDecimal.valueOf(value)
                .multiply(factor());
    }

    protected abstract BigDecimal factor();
}
