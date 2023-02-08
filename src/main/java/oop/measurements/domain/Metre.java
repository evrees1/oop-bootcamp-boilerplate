package oop.measurements.domain;

import oop.measurements.Unit;

import java.math.BigDecimal;

public class Metre extends Unit {

    private final double TO_INCHES_FACTOR = 39.37008;

    public Metre(double value) {
        super(value);
    }

    public Metre plus(Metre b) {
        return new Metre(this.value + b.value);
    }

    public Inch convertToInches() {
        return new Inch(BigDecimal.valueOf(value)
                .multiply(BigDecimal.valueOf(TO_INCHES_FACTOR)).doubleValue());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Metre metre = (Metre) o;

        return Double.compare(metre.value, value) == 0;
    }
}
