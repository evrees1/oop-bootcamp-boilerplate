package oop.parking;

import oop.parking.domain.Car;

import java.util.List;
import java.util.Optional;

public class Assistant {

    private final List<ParkingLot> parkingLots;

    public Assistant(List<ParkingLot> parkingLots) {
        this.parkingLots = parkingLots;
    }

    public void parkCar(Car car) {
        for (ParkingLot lot : this.parkingLots) {
            if (lot.capacityPercentage() < 0.8) {
                lot.parkCar(car);
                return;
            }
        }
    }

    public ParkingLot findParkingLotFor(Car car) {
        for (ParkingLot lot : this.parkingLots) {
            if (lot.contains(car)) {
                return lot;
            }
        }
        return null;
    }

    public boolean isCarParked(Car car) {
        return findParkingLotFor(car) != null;
    }

    public boolean retrieveCar(Car car) {
        ParkingLot lot = findParkingLotFor(car);
        if (lot == null) {
            return false;
        }
        return lot.retrieveCar(car);
    }

    public ParkingLot findLowestOccupancyParkingLot() {
        ParkingLot parkingLot = null;
        double maxOccupancy = 1.0;
        for (ParkingLot lot : this.parkingLots) {
            if (lot.capacityPercentage() < maxOccupancy) {
                parkingLot = lot;
                maxOccupancy = lot.capacityPercentage();
            }
        }
        return parkingLot;
    }

    public Optional<ParkingLot> findParkingLotThatAcceptsHandicapped() {
        return parkingLots.stream()
            .filter(ParkingLot::isAcceptsHandicapped)
            .findFirst();
    }
}
