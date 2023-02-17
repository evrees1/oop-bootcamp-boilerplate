package oop.parking;

import oop.parking.model.Car;
import oop.parking.model.ParkingException;

import java.util.List;
import java.util.stream.Stream;

public class ParkingLots {

    private List<ParkingLot> list;

    public List<ParkingLot> getList() {
        return list;
    }

    public ParkingLots(List<ParkingLot> list) {
        this.list = list;
    }

    public ParkingLot findLotWith(Car car) {
        return list.stream()
                .filter(lot -> lot.contains(car))
                .findFirst()
                .orElseThrow(ParkingException::new);
    }

    public Stream<ParkingLot> stream() {
        return list.stream();
    }
}
