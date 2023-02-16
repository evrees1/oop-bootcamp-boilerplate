package oop.parking;

import oop.parking.model.Car;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.BDDMockito.given;

class ParkingLotsTest {

    @Mock
    private ParkingLot lotA;
    @Mock
    private ParkingLot lotB;
    @Mock
    private ParkingLot lotC;

    private ParkingLots subject;

    private Car car = new Car("1");

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        subject = new ParkingLots(List.of(lotA, lotB, lotC));
    }

    @Test
    void findLotWithCapacityShouldReturnLotWhenLotWithCapacityFound() {
        given(lotA.capacityPercentage()).willReturn(0.9);
        given(lotB.capacityPercentage()).willReturn(0.8);
        given(lotC.capacityPercentage()).willReturn(0.79);

        double maxAcceptableCapacity = 0.8;
        Optional<ParkingLot> actual = subject.findLotWithCapacity(maxAcceptableCapacity);

        assertTrue(actual.isPresent());
        assertEquals(lotC, actual.get());
    }

    @Test
    void findLotWithCapacityShouldReturnEmptyWhenLotWithCapacityNotFound() {
        given(lotA.capacityPercentage()).willReturn(0.9);
        given(lotB.capacityPercentage()).willReturn(0.8);
        given(lotC.capacityPercentage()).willReturn(0.85);

        double maxAcceptableCapacity = 0.8;
        Optional<ParkingLot> actual = subject.findLotWithCapacity(maxAcceptableCapacity);

        assertTrue(actual.isEmpty());
    }

    @Test
    void findLotWithCarShouldReturnLotWhenLotWithCarFound() {
        given(lotA.contains(car)).willReturn(false);
        given(lotB.contains(car)).willReturn(true);

        Optional<ParkingLot> actual = subject.findLotWith(car);

        assertTrue(actual.isPresent());
        assertEquals(lotB, actual.get());
    }

    @Test
    void findLotWithCarShouldReturnEmptyWhenLotWithCarNotFound() {
        given(lotA.contains(car)).willReturn(false);
        given(lotB.contains(car)).willReturn(false);
        given(lotC.contains(car)).willReturn(false);

        Optional<ParkingLot> actual = subject.findLotWith(car);

        assertTrue(actual.isEmpty());
    }

}