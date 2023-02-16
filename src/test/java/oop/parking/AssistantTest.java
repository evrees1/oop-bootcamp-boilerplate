package oop.parking;

import oop.parking.model.Car;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

class AssistantTest {

    private Assistant subject;

    @Mock
    private Car car;
    @Mock
    private ParkingStrategy parkingStrategy;

    @Mock
    private ParkingLots parkingLots;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        subject = new Assistant(parkingLots);
    }

    @Test
    void parkCarShouldParkInReturnedParkingStrategy() {
        given(car.findStrategyToPark()).willReturn(parkingStrategy);

        subject.parkCar(car);

        verify(parkingStrategy).park(car, parkingLots);
    }

//
//    @Test
//    void itShouldParkCarWhenLotWithCapacityFound() {
//        assertFalse(assistant.isCarParked(car));
//
//        assistant.parkCar(car);
//
//        assertTrue(lotA.contains(car));
//    }
//
//    @Test
//    void itShouldBeAbleToRetrieveACar() {
//        assistant.parkCar(car);
//
//        assertTrue(assistant.retrieveCar(car));
//
//        assertFalse(assistant.isCarParked(car));
//    }
//
//    @Test
//    void itShouldNotBeAbleToRetrieveACarThatIsNotParked() {
//        assertFalse(assistant.retrieveCar(car));
//    }
//
//    @Test
//    void itShouldNotParkIfParkingIsOverEightyPercentCapacity() {
//        assistant.parkCar(new Car("1"));
//        assistant.parkCar(new Car("2"));
//        assistant.parkCar(new Car("3"));
//        assistant.parkCar(new Car("4"));
//        assistant.parkCar(new Car("5"));
//        assistant.parkCar(new Car("6"));
//        assistant.parkCar(new Car("7"));
//        assistant.parkCar(new Car("8"));
//        assistant.parkCar(car);
//
//        assertFalse(assistant.isCarParked(car));
//    }
//
//    @Test
//    void itShouldFindLowestOccupancyParkingLot() {
//        List<ParkingLot> parkingLotList = new ArrayList<>();
//        final ParkingLot parkingLot1 = new ParkingLot(5, owner);
//        final ParkingLot parkingLot2 = new ParkingLot(5, owner);
//        parkingLotList.add(parkingLot1);
//        parkingLotList.add(parkingLot2);
//
//        final Assistant assistant1 = new Assistant(parkingLotList);
//        assistant1.parkCar(car);
//
//        assertEquals(assistant1.findLowestOccupancyParkingLot(), parkingLot2);
//    }
//
//    @Test
//    void itShouldFindFirstParkingLotThatAcceptsHandicapped() {
//        List<ParkingLot> parkingLotList = new ArrayList<>();
//        final ParkingLot parkingLot1 = new ParkingLot(5, owner);
//        final ParkingLot parkingLot2 = new ParkingLot(5, owner, true);
//        parkingLotList.add(parkingLot1);
//        parkingLotList.add(parkingLot2);
//
//        assistant = new Assistant(parkingLotList);
//        Optional<ParkingLot> actual = assistant.findParkingLotThatAcceptsHandicapped();
//
//        assertTrue(actual.isPresent());
//        assertEquals(actual.get(), parkingLot2);
//    }
//
//    @Test
//    void itShouldParkLargerCarsIntoLowestOccupancyParkingLot() {
//        List<ParkingLot> parkingLotList = new ArrayList<>();
//        final ParkingLot parkingLot1 = new ParkingLot(5, owner);
//        final ParkingLot parkingLot2 = new ParkingLot(5, owner);
//        parkingLot1.parkCar(new Car(""));
//        parkingLotList.add(parkingLot1);
//        parkingLotList.add(parkingLot2);
//
//        assistant = new Assistant(parkingLotList);
//        ParkingLot actual = assistant.findLowestOccupancyParkingLot();
//
//        assertEquals(actual, parkingLot2);
//    }
}