package oop.parking.domain;

import oop.parking.Owner;
import oop.parking.ParkingLot;
import org.checkerframework.checker.units.qual.C;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertTrue;

class LargeCarParkingStrategyTest {

    private Owner owner;
    private final ParkingLot parkingLotA = new ParkingLot(5, owner);
    private final ParkingLot parkingLotB = new ParkingLot(5, owner);

    private LargeCarParkingStrategy subject = new LargeCarParkingStrategy();

    @Test
    void itShouldParkLargerCarsIntoLowestOccupancyParkingLot() {
        parkingLotA.parkCar(new Car("d"));

        final Car car = new CarBuilder("123")
                .withLarge(true)
                .build();

        subject.park(car, Arrays.asList(parkingLotA, parkingLotB));

        assertTrue(parkingLotB.contains(car));
    }

}