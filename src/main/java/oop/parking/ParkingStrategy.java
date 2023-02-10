package oop.parking;

import oop.parking.domain.Car;

import java.util.List;

public interface ParkingStrategy {

    void park(Car car, List<ParkingLot> parkingLot);
}
