package oop.parking.strategy;

import oop.parking.ParkingLot;
import oop.parking.ParkingLots;
import oop.parking.model.Car;
import oop.parking.model.ParkingException;

import java.util.Comparator;

public class LargeCarParkingStrategy extends AbstractParkingStrategy {

    @Override
    public void park(Car car, ParkingLots parkingLots) {
        ParkingLot parkingLot = applyFilter(parkingLots)
                .min(Comparator.comparing(ParkingLot::capacityPercentage))
                .orElseThrow(ParkingException::new);

        parkingLot.park(car);
    }
}
