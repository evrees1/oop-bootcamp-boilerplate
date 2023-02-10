package oop.parking.domain;

public class CarBuilder {
    private String id;
    private boolean large;
    private boolean handicapped;

    public CarBuilder(String id) {
        this.id = id;
    }

    public CarBuilder withLarge(boolean large) {
        this.large = large;
        return this;
    }

    public CarBuilder withHandicapped(boolean handicapped) {
        this.handicapped = handicapped;
        return this;
    }

    public Car build() {
        return new Car(id, large, handicapped);
    }
}