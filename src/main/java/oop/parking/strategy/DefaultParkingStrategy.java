package oop.parking.strategy;

import oop.parking.ParkingLot;
import oop.parking.ParkingLots;
import oop.parking.model.Car;
import oop.parking.model.ParkingException;

public class DefaultParkingStrategy extends AbstractParkingStrategy {

    public void park(Car car, ParkingLots parkingLots) {
        ParkingLot lot = applyFilter(parkingLots)
                .findFirst()
                .orElseThrow(ParkingException::new);

        lot.park(car);
    }

}
