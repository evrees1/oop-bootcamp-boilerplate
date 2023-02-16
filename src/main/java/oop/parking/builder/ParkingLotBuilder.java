package oop.parking.builder;

import oop.parking.Owner;
import oop.parking.ParkingLot;
import oop.parking.domain.Car;

import java.beans.PropertyChangeSupport;
import java.util.ArrayList;
import java.util.List;

public class ParkingLotBuilder {

    private String id;
    private int capacity;
    private boolean acceptsHandicapped;
    private Owner owner;

    public static ParkingLotBuilder builder() {
        return new ParkingLotBuilder();
    }

    public ParkingLotBuilder withId(String id) {
        this.id = id;
        return this;
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
        return new ParkingLot(id, capacity, acceptsHandicapped, owner);
    }
}
