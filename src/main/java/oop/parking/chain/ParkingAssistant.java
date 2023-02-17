package oop.parking.chain;

import oop.parking.ParkingLots;
import oop.parking.model.Car;

public interface ParkingAssistant {

    boolean park(Car car, ParkingLots parkingLots);

    void setParkingLots(ParkingLots parkingLots);
}
