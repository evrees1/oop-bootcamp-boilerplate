package oop.measurements;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class InchToYardConverter extends MeasurementConvertor {

    @Override
    protected BigDecimal factor() {
        return BigDecimal.valueOf(36);
    }
}
