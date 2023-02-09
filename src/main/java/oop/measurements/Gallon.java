package oop.measurements;

import java.math.BigDecimal;

public class Gallon extends Unit {

    private static final double TO_LITRE_FACTOR = 3.7854;

    public Gallon(double val) {
        super(val);
    }

    public BigDecimal toLitres() {
        return BigDecimal.valueOf(multiplication(TO_LITRE_FACTOR));
    }
}
