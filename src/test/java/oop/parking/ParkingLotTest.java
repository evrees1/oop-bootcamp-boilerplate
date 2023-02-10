package oop.parking;

import oop.parking.domain.Car;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ParkingLotTest {

    private Owner owner;
    private ParkingLot parkingLot;

    @BeforeEach
    void setUp() {
        this.owner = new Owner();
        this.parkingLot = new ParkingLot(2, owner);
    }

    @Test
    void itShouldBeAbleToParkCar() {
        Car car = new Car("ABC-123");
        parkingLot.parkCar(car);

        assertTrue(parkingLot.contains(car));
    }

    @Test
    void itShouldBeAbleToRetrieveACar() {
        Car car = new Car("ABC-123");
        parkingLot.parkCar(car);

        parkingLot.retrieveCar(car);
        assertFalse(parkingLot.getParkedCars().contains(car.getId()));
    }

    @Test
    void itShouldBeAbleToCheckIfCarIsParked() {
        final Car car = new Car("ABC-123");
        parkingLot.parkCar(car);

        assertTrue(parkingLot.contains(car));
    }

    @Test
    void itShouldNotParkACarWhenIsFull() {
        Car carToFind = new Car("ABC-123");
        parkingLot.parkCar(new Car("1"));
        parkingLot.parkCar(new Car("2"));

        parkingLot.parkCar(carToFind);

        assertFalse(parkingLot.contains(carToFind));
    }

    @Test
    void itShouldReturnPercentageOfUsedCapacity() {
        parkingLot.parkCar(new Car("1"));

        assertEquals(parkingLot.capacityPercentage(), 0.5);
    }
}
