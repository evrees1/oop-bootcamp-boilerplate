package oop.parking.strategy;

import oop.parking.ParkingLot;
import oop.parking.ParkingStrategy;
import oop.parking.ParkingLots;

import java.util.stream.Stream;

public abstract class AbstractParkingStrategy implements ParkingStrategy {

    private static final double MAX_ALLOWABLE_CAPACITY = 0.80;

    protected Stream<ParkingLot> applyFilter(ParkingLots parkingLots) {
        return parkingLots.getList().stream()
                .filter(this::meetsParkingCriteria);
    }

    protected boolean meetsParkingCriteria(ParkingLot parkingLot) {
        return parkingLot.capacityPercentage() < MAX_ALLOWABLE_CAPACITY;
    }
}
