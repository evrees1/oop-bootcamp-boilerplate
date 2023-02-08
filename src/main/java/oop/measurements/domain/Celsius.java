package oop.measurements.domain;

import oop.measurements.Unit;
import org.checkerframework.checker.units.qual.C;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

public class Celsius extends Unit {

    public static final int SCALE = 2;

    public Celsius(double value) {
        super(value);
    }

    public double convertToFahrenheit() {
        return BigDecimal.valueOf(value)
                .multiply(subFactor(), new MathContext(SCALE, RoundingMode.HALF_UP))
                .doubleValue() + 32;
    }

    private BigDecimal subFactor() {
        return BigDecimal.valueOf(9)
                .divide(BigDecimal.valueOf(5), 4, RoundingMode.HALF_UP);
    }
}
