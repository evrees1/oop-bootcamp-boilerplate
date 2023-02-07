package oop.measurements;

import java.math.BigDecimal;

public class MetresToCentimetresConverter {

    public BigDecimal convert(double metres) {
        return BigDecimal.valueOf(metres)
                .multiply(BigDecimal.valueOf(100));
    }
}
