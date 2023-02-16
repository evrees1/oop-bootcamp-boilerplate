package oop.parking.domain;


import oop.parking.ParkingStrategy;
import oop.parking.builder.CarBuilder;
import oop.parking.strategy.DefaultParkingStrategy;
import oop.parking.strategy.HandicapParkingStrategy;
import oop.parking.strategy.LargeCarParkingStrategy;
import oop.parking.strategy.LargeHandicapParkingStrategy;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.junit.jupiter.api.Assertions.assertTrue;

class CarTest {

    @Test
    void itShouldReturnDefaultStrategyWhenCarDefault() {
        Car car = new CarBuilder("abc")
                .build();

        ParkingStrategy actual = car.findStrategyToPark();

        assertInstanceOf(DefaultParkingStrategy.class, actual);
    }

    @Test
    void itShouldReturnLargeStrategyWhenCarLarge() {
        Car car = new CarBuilder("abc")
                .withLarge()
                .build();

        ParkingStrategy actual = car.findStrategyToPark();

        assertTrue(actual instanceof LargeCarParkingStrategy);
    }

    @Test
    void itShouldReturnHandicapStrategyWhenCarHandicap() {
        Car car = new CarBuilder("abc")
                .withHandicapped()
                .build();

        ParkingStrategy actual = car.findStrategyToPark();

        assertTrue(actual instanceof HandicapParkingStrategy);
    }

    @Test
    void itShouldReturnLargeHandicapStrategyWhenCarLargeHandicap() {
        Car car = new CarBuilder("abc")
                .withHandicapped()
                .withLarge()
                .build();

        ParkingStrategy actual = car.findStrategyToPark();

        assertTrue(actual instanceof LargeHandicapParkingStrategy);
    }

}