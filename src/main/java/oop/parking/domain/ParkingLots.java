package oop.parking.domain;

import oop.parking.ParkingLot;

import java.util.List;
import java.util.Optional;

public class ParkingLots {

    private List<ParkingLot> list;

    public ParkingLots(List<ParkingLot> list) {
        this.list = list;
    }

    public Optional<ParkingLot> findLotWithCapacity(double maxAcceptableCapacity) {
        return list.stream()
                .filter(lot -> lot.capacityPercentage() < maxAcceptableCapacity)
                .findFirst();
    }

    public Optional<ParkingLot> findLotWith(Car car) {
        return list.stream()
                .filter(lot -> lot.contains(car))
                .findFirst();
    }
}
