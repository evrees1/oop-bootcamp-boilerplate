package oop.parking.functional;

import oop.parking.Assistant;
import oop.parking.ParkingLot;
import oop.parking.builder.ParkingLotBuilder;
import oop.parking.domain.Car;
import oop.parking.builder.CarBuilder;
import oop.parking.ParkingLots;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AssistantFunctionalTest {

    private Assistant assistant;

    private ParkingLot lotA = new ParkingLot();
    private ParkingLot lotB = ParkingLotBuilder.builder()
            .withCapacity(2)
            .withAcceptsHandicapped()
            .build();

    private ParkingLot lotC = new ParkingLot();
    private ParkingLot lotD = ParkingLotBuilder.builder()
            .withCapacity(2)
            .withAcceptsHandicapped()
            .build();

    @BeforeEach
    void setUp() {
        ParkingLots lots = new ParkingLots(List.of(lotA, lotB, lotC, lotD));
        assistant = new Assistant(lots);
    }

    @Test
    public void itShould() {
        Car sedan = new Car("sedan-1");
        Car hatch = new Car("hatch-1");
        testDefault(sedan, hatch);

        testLargeCars();
        testHandycapableCars();
        test80PercentLimit();
        testRetrieval(sedan, hatch);

        Car truck = large("TRUCK-1");
        parkAndAssert(truck, lotA);
    }

    private void testDefault(Car... cars) {
        Stream.of(cars).forEach(car -> {
            assistant.parkCar(car);
            assertTrue(lotA.contains(car));
        });
    }

    private void testLargeCars() {
        Car suv = large("SUV-1");
        parkAndAssert(suv, lotB);

        Car van = large("van-1");
        parkAndAssert(van, lotC);
    }

    private void testHandycapableCars() {
        Car handicapableSedan = new CarBuilder("sedan-2")
                .withHandicapped()
                .build();
        parkAndAssert(handicapableSedan, lotB);

        Car handicapableSuv = new CarBuilder("SUV-2")
                .withHandicapped()
                .withLarge()
                .build();
        parkAndAssert(handicapableSuv, lotD);

        Car handicapableHatch = new CarBuilder("hatch-2")
                .withHandicapped()
                .build();
        parkAndAssert(handicapableHatch, lotD);
    }

    private void test80PercentLimit() {
        parkAndAssert(new Car("A1"), lotA);
        parkAndAssert(new Car("A2"), lotA);
        //LotA full
        parkAndAssert(new Car("A3"), lotC);
    }

    private void testRetrieval(Car... cars) {
        Stream.of(cars).forEach(car -> {
            assistant.retrieveCar(car);
            assertFalse(lotA.contains(car));
        });
    }

    private Car large(String id) {
        return new CarBuilder(id)
                .withLarge()
                .build();
    }

    private void parkAndAssert(Car car, ParkingLot lot) {
        assistant.parkCar(car);
        assertTrue(lot.contains(car));
    }
}
