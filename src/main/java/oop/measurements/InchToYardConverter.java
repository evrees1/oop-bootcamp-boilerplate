package oop.measurements;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class InchToYardConverter extends MeasurementConvertor {

    @Override
    public BigDecimal convert(double value) {
        return divide(value);
    }

    @Override
    protected BigDecimal factor() {
        return BigDecimal.valueOf(36);
    }
}
