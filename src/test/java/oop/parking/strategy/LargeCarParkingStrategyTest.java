package oop.parking.strategy;

import oop.parking.model.ParkingException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

class LargeCarParkingStrategyTest extends BaseParkingStrategyTest {

    @BeforeEach
    void setUp() {
        super.setUp();
        subject = new LargeCarParkingStrategy();
    }

    @Test
    void itShouldParkLargerCarsIntoLowestOccupancyParkingLot() {
        given(lotA.capacityPercentage()).willReturn(0.80);
        given(lotB.capacityPercentage()).willReturn(0.40);
        given(lotB.hasFreeSlots()).willReturn(true);
        given(lotC.capacityPercentage()).willReturn(0.50);

        subject.park(car, parkingLots);

        verify(lotB).park(car);
    }

    @Test
    void shouldThrowExceptionWhenParkingNotFound() {
        given(lotA.capacityPercentage()).willReturn(0.80);
        given(lotB.capacityPercentage()).willReturn(0.80);
        given(lotC.capacityPercentage()).willReturn(0.80);

        assertThrows(ParkingException.class, () -> subject.park(car, parkingLots));

        verifyNoParks();
    }

}