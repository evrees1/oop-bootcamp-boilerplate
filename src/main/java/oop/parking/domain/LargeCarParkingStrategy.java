package oop.parking.domain;

import oop.parking.ParkingLot;
import oop.parking.ParkingStrategy;

import java.util.List;
import java.util.Optional;

public class LargeCarParkingStrategy implements ParkingStrategy {

    @Override
    public void park(Car car, List<ParkingLot> parkingLots) {
        Optional<ParkingLot> parkingLot = Optional.empty();
        double maxOccupancy = 1.0;
        for (ParkingLot lot : parkingLots) {
            if (lot.capacityPercentage() < maxOccupancy) {
                parkingLot = Optional.of(lot);
                maxOccupancy = lot.capacityPercentage();
            }
        }
        parkingLot.ifPresent(p -> p.parkCar(car));
    }
}
