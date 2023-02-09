package oop.measurements;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Unit extends BigDecimal {

    protected final int SCALE = 4;

    public Unit(double val) {
        super(val);
    }

    public double value() {
        return doubleValue();
    }

    protected double division(double factor) {
        return divide(BigDecimal.valueOf(factor), SCALE, RoundingMode.HALF_UP)
                .doubleValue();
    }

    protected double multiplication(double factor) {
        return BigDecimal.valueOf(value())
                .multiply(BigDecimal.valueOf(factor)).doubleValue();
    }

}
