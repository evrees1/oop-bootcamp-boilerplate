package oop.parking.strategy;

import oop.parking.ParkingLot;
import oop.parking.ParkingLots;
import oop.parking.model.Car;

import java.util.Comparator;
import java.util.Optional;

public class LargeHandicapParkingStrategy extends AbstractParkingStrategy {

    @Override
    public void park(Car car, ParkingLots parkingLots) {
        Optional<ParkingLot> parkingLot = applyFilter(parkingLots)
                .min(Comparator.comparing(ParkingLot::capacityPercentage));

        parkingLot.ifPresent(p -> p.park(car));
    }

    @Override
    protected boolean meetsParkingCriteria(ParkingLot parkingLot) {
        return parkingLot.hasFreeSlots() && parkingLot.isAcceptsHandicapped();
    }
}
