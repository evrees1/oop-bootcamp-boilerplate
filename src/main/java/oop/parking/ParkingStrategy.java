package oop.parking;

import oop.parking.domain.Car;

public interface ParkingStrategy {

    void park(Car car, ParkingLots parkingLots);
}
