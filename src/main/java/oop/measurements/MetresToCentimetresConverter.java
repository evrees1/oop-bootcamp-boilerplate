package oop.measurements;

import java.math.BigDecimal;

public class MetresToCentimetresConverter extends MeasurementConvertor {

    public BigDecimal convert(double metres) {
        return multiply(metres);
    }

    @Override
    protected BigDecimal factor() {
        return BigDecimal.valueOf(100);
    }
}
