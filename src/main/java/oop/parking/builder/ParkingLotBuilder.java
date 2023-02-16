package oop.parking.builder;

import oop.parking.Owner;
import oop.parking.ParkingLot;

public class ParkingLotBuilder {

    private int capacity;
    private boolean acceptsHandicapped;
    private Owner owner;

    public static ParkingLotBuilder builder() {
        return new ParkingLotBuilder();
    }

    public ParkingLotBuilder withCapacity(int capacity) {
        this.capacity = capacity;
        return this;
    }

    public ParkingLotBuilder withAcceptsHandicapped() {
        this.acceptsHandicapped = true;
        return this;
    }

    public ParkingLotBuilder withOwner(Owner owner) {
        this.owner = owner;
        return this;
    }

    public ParkingLot build() {
        return new ParkingLot(capacity, acceptsHandicapped, owner);
    }
}
