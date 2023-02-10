package oop.parking;

import oop.parking.domain.Car;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;


class OwnerTest {

    private Owner owner;

    @BeforeEach
    void setUp() {
        this.owner = new Owner();
    }
    
    @Test
    void itShouldGiveAnOvercrowdedAlertWhenCapacityLimitIsExceeded() {
        ParkingLot parkingLot = new ParkingLot(5, owner);

        parkingLot.parkCar(new Car("123"));
        parkingLot.parkCar(new Car("456"));
        parkingLot.parkCar(new Car("789"));
        parkingLot.parkCar(new Car("000"));
        assertTrue(owner.isAlerted());
    }

    @Test
    void itShouldNotGiveAnOvercrowdedAlertWhenBelowCapacityLimit() {
        ParkingLot parkingLot = new ParkingLot(4, owner);

        parkingLot.parkCar(new Car("1"));
        parkingLot.parkCar(new Car("2"));
        assertFalse(owner.isAlerted());
    }

    @Test
    void itShouldGiveAnLowOccupancyAlertWhenCapacityIsBellowTheLimit() {
        ParkingLot parkingLot = new ParkingLot(10, owner);
        parkingLot.parkCar(new Car("1"));

        assertTrue(owner.isLowOccupancyAlerted());
    }

    @Test
    void itShouldNotGiveAnLowOccupancyAlertWhenCapacityIsAboveTheLimit() {
        ParkingLot parkingLot = new ParkingLot(10, owner);
        parkingLot.parkCar(new Car("1"));
        parkingLot.parkCar(new Car("2"));

        assertFalse(owner.isLowOccupancyAlerted());
    }
}
