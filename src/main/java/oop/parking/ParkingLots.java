package oop.parking;

import oop.parking.model.Car;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public class ParkingLots {

    private List<ParkingLot> list;

    public List<ParkingLot> getList() {
        return list;
    }

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

    public Stream<ParkingLot> stream() {
        return list.stream();
    }
}
