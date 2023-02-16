package oop.parking.builder;

import oop.parking.model.Car;

public class CarBuilder {
    private String id;
    private boolean large;
    private boolean handicapped;

    public CarBuilder(String id) {
        this.id = id;
    }

    public CarBuilder withLarge() {
        this.large = true;
        return this;
    }

    public CarBuilder withHandicapped() {
        this.handicapped = true;
        return this;
    }

    public Car build() {
        return new Car(id, large, handicapped);
    }
}