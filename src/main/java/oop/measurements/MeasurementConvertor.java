package oop.measurements;

import java.math.BigDecimal;
import java.math.RoundingMode;

public abstract class MeasurementConvertor {

    private final int SCALE = 4;

    public BigDecimal convert(double value) {
        return BigDecimal.valueOf(value)
                .divide(factor(), SCALE, RoundingMode.HALF_UP);
    }

    protected abstract BigDecimal factor();
}
