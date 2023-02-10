package oop.parking.domain;

import oop.parking.ParkingLot;
import oop.parking.ParkingStrategy;

import java.util.List;
import java.util.Optional;

public class HandicapParkingStrategy implements ParkingStrategy {

    @Override
    public void park(Car car, List<ParkingLot> parkingLots) {
        Optional<ParkingLot> parkingLot = parkingLots.stream()
                .filter(ParkingLot::isAcceptsHandicapped)
                .findFirst();

        parkingLot.ifPresent(p -> p.parkCar(car));
    }
}
