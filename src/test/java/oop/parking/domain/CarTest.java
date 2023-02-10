package oop.parking.domain;


import oop.parking.ParkingStrategy;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

class CarTest {

    @Test
    void itShouldReturnDefaultStrategyWhenCarDefault() {
        Car car = new CarBuilder("abc")
                .build();

        ParkingStrategy actual = car.findStrategyToPark();

        assertTrue(actual instanceof DefaultParkingStrategy);
    }

    @Test
    void itShouldReturnLargeStrategyWhenCarLarge() {
        Car car = new CarBuilder("abc")
                .withLarge(true)
                .build();

        ParkingStrategy actual = car.findStrategyToPark();

        assertTrue(actual instanceof LargeCarParkingStrategy);
    }

    @Test
    void itShouldReturnHandicapStrategyWhenCarHandicap() {
        Car car = new CarBuilder("abc")
                .withHandicapped(true)
                .build();

        ParkingStrategy actual = car.findStrategyToPark();

        assertTrue(actual instanceof HandicapParkingStrategy);
    }

    @Test
    void itShouldReturnLargeHandicapStrategyWhenCarLargeHandicap() {
        Car car = new CarBuilder("abc")
                .withHandicapped(true)
                .withLarge(true)
                .build();

        ParkingStrategy actual = car.findStrategyToPark();

        assertTrue(actual instanceof LargeHandicapParkingStrategy);
    }

}