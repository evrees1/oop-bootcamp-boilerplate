package oop.parking;

import oop.parking.model.Car;

public interface ParkingStrategy {

    void park(Car car, ParkingLots parkingLots);
}
