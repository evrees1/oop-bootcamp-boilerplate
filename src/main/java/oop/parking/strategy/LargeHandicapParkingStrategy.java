package oop.parking.strategy;

import oop.parking.ParkingLot;
import oop.parking.domain.Car;
import oop.parking.ParkingLots;

import java.util.Comparator;
import java.util.Optional;

public class LargeHandicapParkingStrategy extends AbstractParkingStrategy {

    @Override
    public void park(Car car, ParkingLots parkingLots) {
        Optional<ParkingLot> parkingLot = applyFilter(parkingLots)
                .min(Comparator.comparing(ParkingLot::capacityPercentage));

        parkingLot.ifPresent(p -> p.parkCar(car));
    }

    @Override
    protected boolean meetsParkingCriteria(ParkingLot parkingLot) {
        return parkingLot.hasFreeSlots() && parkingLot.isAcceptsHandicapped();
    }
}
