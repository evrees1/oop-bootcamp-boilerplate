package oop.parking.domain;

import oop.parking.ParkingStrategy;

public class Car {

    private String id;
    private boolean large;
    private boolean handicapped;

    public Car(String id) {
        this.id = id;
    }

    public Car(String id, boolean large, boolean handicapped) {
        this.id = id;
        this.large = large;
        this.handicapped = handicapped;
    }

    public ParkingStrategy findStrategyToPark() {
        if (large && handicapped) {
            return new LargeHandicapParkingStrategy();
        }
        if (large) {
            return new LargeCarParkingStrategy();
        } else if (handicapped) {
            return new HandicapParkingStrategy();
        }
        return new DefaultParkingStrategy();
    }

    public String getId() {
        return id;
    }

}
