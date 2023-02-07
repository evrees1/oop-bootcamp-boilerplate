package oop.measurements;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class FeetToMetresConverter extends MeasurementConvertor {

    @Override
    protected BigDecimal factor() {
        return BigDecimal.valueOf(3.281);
    }
}
