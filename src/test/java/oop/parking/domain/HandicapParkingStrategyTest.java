package oop.parking.domain;

import oop.parking.Assistant;
import oop.parking.Owner;
import oop.parking.ParkingLot;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


class HandicapParkingStrategyTest {

    private Owner owner;
    private final ParkingLot parkingLot1 = new ParkingLot(5, owner, true);
    private final ParkingLot parkingLot2 = new ParkingLot(5, owner, true);
    private final HandicapParkingStrategy subject = new HandicapParkingStrategy();

    @Test
    void itShouldParkLargerCarsIntoLowestOccupancyParkingLot() {
        final Car car = new CarBuilder("123")
                .withHandicapped(true)
                .build();

        subject.park(car, Arrays.asList(parkingLot1, parkingLot2));

        assertTrue(parkingLot1.contains(car));
    }

}