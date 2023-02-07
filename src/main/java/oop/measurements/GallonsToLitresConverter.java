package oop.measurements;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class GallonsToLitresConverter extends MeasurementConvertor {

    public BigDecimal convert(double gallons) {
        return multiply(gallons);
    }

    @Override
    protected BigDecimal factor() {
        return BigDecimal.valueOf(3.7854);
    }
}
