package oop.measurements.domain;

import oop.measurements.Unit;

public class Inch extends Unit {


    public Inch(double value) {
        super(value);
    }

    public Inch plus(Inch b) {
        return new Inch(this.value + b.value);
    }

    public Inch add(Metre metre) {
        Inch metreInInches = metre.convertToInches();
        // convert meter to inches
        // return plus();
        return new Inch(this.value + metreInInches.value);
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Inch inch = (Inch) o;

        return Double.compare(inch.value, value) == 0;
    }
}
