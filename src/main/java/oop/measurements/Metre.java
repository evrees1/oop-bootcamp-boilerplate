package oop.measurements;

import java.math.BigDecimal;

public class Metre extends Unit {

    private static final double TO_INCHES_FACTOR = 39.37008;
    private static final double TO_CENTIMETRE_FACTOR = 100;

    public Metre(double value) {
        super(value);
    }

    public Metre add(Metre metre) {
        return new Metre(this.value() + metre.value());
    }

    public Inch toInches() {
        return new Inch(multiplication(TO_INCHES_FACTOR));
    }

    public BigDecimal toCentimetres() {
        return new Centimetre(multiplication(TO_CENTIMETRE_FACTOR));
    }
}
