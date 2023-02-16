package oop.parking.domain;

import oop.parking.ParkingStrategy;
import oop.parking.strategy.DefaultParkingStrategy;
import oop.parking.strategy.HandicapParkingStrategy;
import oop.parking.strategy.LargeCarParkingStrategy;
import oop.parking.strategy.LargeHandicapParkingStrategy;

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

    public String getId() {
        return id;
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

}
