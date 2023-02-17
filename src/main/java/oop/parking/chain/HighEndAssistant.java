package oop.parking.chain;

import oop.parking.ParkingLots;
import oop.parking.model.Car;

public class HighEndAssistant extends AbstractParkingAssistant {

    @Override
    public boolean park(Car car, ParkingLots parkingLots) {
        return processPark(car, parkingLots);
    }
}
