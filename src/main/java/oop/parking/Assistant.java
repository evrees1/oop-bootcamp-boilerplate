package oop.parking;

import oop.parking.model.Car;

import java.util.Optional;

public class Assistant {

    private ParkingLots parkingLots;

    public Assistant(ParkingLots parkingLots) {
        this.parkingLots = parkingLots;
    }

    public void parkCar(Car car) {
        ParkingStrategy parkingStrategy = car.findStrategyToPark();
        parkingStrategy.park(car, parkingLots);
    }

    public void retrieveCar(Car car) {
        Optional<ParkingLot> lot = parkingLots.findLotWith(car);
        lot.ifPresent(l -> l.retrieve(car));
    }
}
