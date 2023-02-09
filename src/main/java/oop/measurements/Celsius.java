package oop.measurements;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

public class Celsius extends Unit {

    public static final int SCALE = 2;

    public Celsius(double value) {
        super(value);
    }

    public double toFahrenheit() {
        return BigDecimal.valueOf(value())
                .multiply(subFactor(), new MathContext(SCALE, RoundingMode.HALF_UP))
                .doubleValue() + 32;
    }

    private BigDecimal subFactor() {
        return BigDecimal.valueOf(1.8);
    }
}
