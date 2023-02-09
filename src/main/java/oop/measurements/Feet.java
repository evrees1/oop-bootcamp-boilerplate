package oop.measurements;

public class Feet extends Unit {

    private static final double TO_METRES_FACTOR = 3.281;

    public Feet(double val) {
        super(val);
    }

    public Metre toMetres() {
        return new Metre(division(TO_METRES_FACTOR));
    }
}
