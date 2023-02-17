package oop.parking.functional;

import oop.parking.Owner;
import oop.parking.ParkingLot;
import oop.parking.ParkingLots;
import oop.parking.builder.CarBuilder;
import oop.parking.builder.ParkingLotBuilder;
import oop.parking.chain.DefaultAssistant;
import oop.parking.chain.HighEndAssistant;
import oop.parking.model.Car;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.verify;

public class AssistantFunctionalTest {

    private Owner owner = new Owner();
    private DefaultAssistant assistant;

    @Mock
    private HighEndAssistant highEndCertifiedAssistant;

    private ParkingLot lotA = new ParkingLot();
    private ParkingLot lotB = ParkingLotBuilder.builder()
            .withCapacity(2)
            .withAcceptsHandicapped()
            .build();

    private ParkingLot lotC = new ParkingLot();
    private ParkingLot lotD = ParkingLotBuilder.builder()
            .withCapacity(4)
            .withAcceptsHandicapped()
            .build();

    private ParkingLots parkingLots;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        parkingLots = new ParkingLots(List.of(lotA, lotB, lotC, lotD));
        assistant = new DefaultAssistant(parkingLots);

        parkingLots.getList().forEach(l -> l.addPropertyChangeListener(owner));

//        highEndCertifiedAssistant = new HighEndAssistant(new ParkingLots(List.of(highEndLot)));
        assistant.addAssistant(highEndCertifiedAssistant);
    }

    @Test
    public void shouldUpdateLotsWithCarsAndFireEvents() {
        Car sedan = new Car("sedan-1");
        Car hatch = new Car("hatch-1");
        testDefault(sedan, hatch);

        Car van = testLargeCars();
        testHandycapableCars();
        testCapacityLimits();
        testRetrieval(sedan, hatch);

        Car truck = large("TRUCK-1");
        parkAndAssert(truck, lotA);

        testHighOccupancyAlert();
        testLowOccupancyAlert(van);

        testHighEndCar();
    }

    private void testDefault(Car... cars) {
        Stream.of(cars).forEach(car -> {
            assistant.park(car, parkingLots);
            assertTrue(lotA.contains(car));
        });
    }

    private Car testLargeCars() {
        Car suv = large("SUV-1");
        parkAndAssert(suv, lotB);

        Car van = large("van-1");
        parkAndAssert(van, lotC);
        return van;
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

    private void testCapacityLimits() {
        parkAndAssert(new Car("A1"), lotA);
        parkAndAssert(new Car("A2"), lotA);
        //LotA at capacity
        Car overCapacityCar = new Car("A3");
        assistant.park(overCapacityCar, parkingLots);
        assertFalse(lotA.contains(overCapacityCar));
        assertTrue(lotC.contains(overCapacityCar));
    }

    private void testRetrieval(Car... cars) {
        Stream.of(cars).forEach(car -> {
            assistant.retrieve(car);
            assertFalse(lotA.contains(car));
        });
    }

    private void testHighOccupancyAlert() {
        assertFalse(owner.isHighOccupancyAlerted());

        Car handicapableCar = new CarBuilder("hatch-2")
                .withHandicapped()
                .build();

        parkAndAssert(handicapableCar, lotD);
        assertTrue(owner.isHighOccupancyAlerted());
    }

    private void testLowOccupancyAlert(Car van) {
        assertFalse(owner.isLowOccupancyAlerted());
        assistant.retrieve(van);
        assertTrue(owner.isLowOccupancyAlerted());
    }

    private void testHighEndCar() {
        Car fancyCar = new CarBuilder("lambo-1")
                .withHighEnd()
                .build();

        assistant.park(fancyCar, parkingLots);

        verify(highEndCertifiedAssistant).park(fancyCar, parkingLots);
    }

    private Car large(String id) {
        return new CarBuilder(id)
                .withLarge()
                .build();
    }

    private void parkAndAssert(Car car, ParkingLot lot) {
        assistant.park(car, parkingLots);
        assertTrue(lot.contains(car));
    }
}
