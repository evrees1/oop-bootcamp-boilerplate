package oop.parking;

import oop.parking.domain.Car;
import oop.parking.domain.CarBuilder;
import org.checkerframework.checker.units.qual.C;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class AssistantTest {
    private String carId;
    private Owner owner;
    private Car car;

    private ParkingLot lotA = new ParkingLot(5, owner);
    private ParkingLot lotB = new ParkingLot(5, owner);
    private Assistant assistant;

    @BeforeEach
    void setUp() {
        this.owner = new Owner();
        this.car = new Car( "ABC-123");
        this.carId = "ABC-123";

        this.assistant = new Assistant(List.of(lotA, lotB));
    }


    @Test
    void itShouldParkCarWhenLotWithCapacityFound() {
        assertFalse(assistant.isCarParked(car));

        assistant.parkCar(car);

        assertTrue(lotA.contains(car));
    }

    @Test
    void itShouldBeAbleToRetrieveACar() {
        assistant.parkCar(car);

        assertTrue(assistant.retrieveCar(car));

        assertFalse(assistant.isCarParked(car));
    }

    @Test
    void itShouldNotBeAbleToRetrieveACarThatIsNotParked() {
        assertFalse(assistant.retrieveCar(car));
    }

    @Test
    void itShouldNotParkIfParkingIsOverEightyPercentCapacity() {
        assistant.parkCar(new Car("1"));
        assistant.parkCar(new Car("2"));
        assistant.parkCar(new Car("3"));
        assistant.parkCar(new Car("4"));
        assistant.parkCar(new Car("5"));
        assistant.parkCar(new Car("6"));
        assistant.parkCar(new Car("7"));
        assistant.parkCar(new Car("8"));
        assistant.parkCar(car);

        assertFalse(assistant.isCarParked(car));
    }

    @Test
    void itShouldFindLowestOccupancyParkingLot() {
        List<ParkingLot> parkingLotList = new ArrayList<>();
        final ParkingLot parkingLot1 = new ParkingLot(5, owner);
        final ParkingLot parkingLot2 = new ParkingLot(5, owner);
        parkingLotList.add(parkingLot1);
        parkingLotList.add(parkingLot2);

        final Assistant assistant1 = new Assistant(parkingLotList);
        assistant1.parkCar(car);

        assertEquals(assistant1.findLowestOccupancyParkingLot(), parkingLot2);
    }

    @Test
    void itShouldFindFirstParkingLotThatAcceptsHandicapped() {
        List<ParkingLot> parkingLotList = new ArrayList<>();
        final ParkingLot parkingLot1 = new ParkingLot(5, owner);
        final ParkingLot parkingLot2 = new ParkingLot(5, owner, true);
        parkingLotList.add(parkingLot1);
        parkingLotList.add(parkingLot2);

        assistant = new Assistant(parkingLotList);
        Optional<ParkingLot> actual = assistant.findParkingLotThatAcceptsHandicapped();

        assertTrue(actual.isPresent());
        assertEquals(actual.get(), parkingLot2);
    }

    @Test
    void itShouldParkLargerCarsIntoLowestOccupancyParkingLot() {
        List<ParkingLot> parkingLotList = new ArrayList<>();
        final ParkingLot parkingLot1 = new ParkingLot(5, owner);
        final ParkingLot parkingLot2 = new ParkingLot(5, owner);
        parkingLot1.parkCar(new Car(""));
        parkingLotList.add(parkingLot1);
        parkingLotList.add(parkingLot2);

        assistant = new Assistant(parkingLotList);
        ParkingLot actual = assistant.findLowestOccupancyParkingLot();

        assertEquals(actual, parkingLot2);
    }
}