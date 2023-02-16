package oop.parking;

import oop.parking.builder.ParkingLotBuilder;
import oop.parking.domain.Car;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@Disabled
class OwnerTest {

    private Owner owner;
    private ParkingLotBuilder parkingLotBuilder;
    private ParkingLot parkingLot;

    @BeforeEach
    void setUp() {
        this.owner = new Owner();

        parkingLotBuilder = ParkingLotBuilder.builder()
                .withOwner(owner);

    }
    
    @Test
    void itShouldGiveAnOvercrowdedAlertWhenCapacityLimitIsExceeded() {
        parkingLot = parkingLotBuilder
                .withCapacity(5)
                .build();

        parkingLot.parkCar(new Car("123"));
        parkingLot.parkCar(new Car("456"));
        parkingLot.parkCar(new Car("789"));
        parkingLot.parkCar(new Car("000"));
        assertTrue(owner.isAlerted());
    }

    @Test
    void itShouldNotGiveAnOvercrowdedAlertWhenBelowCapacityLimit() {
        parkingLot = parkingLotBuilder
                .withCapacity(4)
                .build();

        parkingLot.parkCar(new Car("1"));
        parkingLot.parkCar(new Car("2"));
        assertFalse(owner.isAlerted());
    }

    @Test
    void itShouldGiveAnLowOccupancyAlertWhenCapacityIsBellowTheLimit() {
        parkingLot = parkingLotBuilder
                .withCapacity(10)
                .build();

        parkingLot.parkCar(new Car("1"));

        assertTrue(owner.isLowOccupancyAlerted());
    }

    @Test
    void itShouldNotGiveAnLowOccupancyAlertWhenCapacityIsAboveTheLimit() {
        parkingLot = parkingLotBuilder
                .withCapacity(10)
                .build();

        parkingLot.parkCar(new Car("1"));
        parkingLot.parkCar(new Car("2"));

        assertFalse(owner.isLowOccupancyAlerted());
    }
}
