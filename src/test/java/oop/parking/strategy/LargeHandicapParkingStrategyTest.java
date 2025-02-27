package oop.parking.strategy;

import oop.parking.model.ParkingException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

class LargeHandicapParkingStrategyTest extends BaseParkingStrategyTest {

    @BeforeEach
    void setUp() {
        super.setUp();
        subject = new LargeHandicapParkingStrategy();
    }

    @Test
    void itShouldParkLargerCarsIntoLowestOccupancyParkingLotThatAcceptsHandicapped() {
        given(lotA.capacityPercentage()).willReturn(0.80);
        given(lotB.capacityPercentage()).willReturn(0.40);
        given(lotB.isAcceptsHandicapped()).willReturn(false);
        given(lotC.capacityPercentage()).willReturn(0.50);
        given(lotC.isAcceptsHandicapped()).willReturn(true);
        given(lotC.hasFreeSlots()).willReturn(true);

        subject.park(car, parkingLots);

        verify(lotC).park(car);
    }

    @Test
    void shouldThrowExceptionWhenParkingNotFound() {
        given(lotA.capacityPercentage()).willReturn(0.80);
        given(lotB.capacityPercentage()).willReturn(0.80);
        given(lotC.capacityPercentage()).willReturn(0.40);
        given(lotC.isAcceptsHandicapped()).willReturn(false);

        assertThrows(ParkingException.class, () -> subject.park(car, parkingLots));

        verifyNoParks();
    }

}