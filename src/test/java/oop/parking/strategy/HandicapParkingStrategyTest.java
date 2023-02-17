package oop.parking.strategy;

import oop.parking.model.ParkingException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;


class HandicapParkingStrategyTest extends BaseParkingStrategyTest {

    @BeforeEach
    void setUp() {
        super.setUp();
        subject = new HandicapParkingStrategy();
    }

    @Test
    void shouldParkCarWhenAcceptableLotFound() {
        given(lotA.hasFreeSlots()).willReturn(true);
        given(lotA.isAcceptsHandicapped()).willReturn(false);
        given(lotB.hasFreeSlots()).willReturn(false);
        given(lotC.hasFreeSlots()).willReturn(true);
        given(lotC.isAcceptsHandicapped()).willReturn(true);

        subject.park(car, parkingLots);

        verify(lotC).park(car);
    }

    @Test
    void shouldThrowExceptionWhenAcceptableLotNotFound() {
        given(lotA.isAcceptsHandicapped()).willReturn(false);
        given(lotB.isAcceptsHandicapped()).willReturn(false);
        given(lotC.isAcceptsHandicapped()).willReturn(false);

        assertThrows(ParkingException.class, () -> subject.park(car, parkingLots));

        verifyNoParks();
    }
}