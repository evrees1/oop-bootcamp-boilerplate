package oop.measurements;

public class Inch extends Unit {

    private static final int TO_YARDS_FACTOR = 36;

    public Inch(double value) {
        super(value);
    }

    public Inch add(Inch inch) {
        return new Inch(this.value() + inch.value());
    }

    public Inch add(Metre metre) {
        Inch metreInInches = metre.toInches();
        return new Inch(this.value() + metreInInches.value());
    }

    public Yard toYards() {
        return new Yard(division(TO_YARDS_FACTOR));
    }
}

