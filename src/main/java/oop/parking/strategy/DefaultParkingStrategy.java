package oop.parking.strategy;

import oop.parking.ParkingLot;
import oop.parking.domain.Car;
import oop.parking.ParkingLots;

import java.util.Optional;

public class DefaultParkingStrategy extends AbstractParkingStrategy {

    public void park(Car car, ParkingLots parkingLots) {
        Optional<ParkingLot> lot = applyFilter(parkingLots)
                .findFirst();

        lot.ifPresent(l -> l.parkCar(car));
    }

}
