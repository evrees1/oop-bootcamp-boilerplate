package oop.parking.strategy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

class DefaultParkingStrategyTest extends BaseParkingStrategyTest {

    @BeforeEach
    void setUp() {
        super.setUp();
        subject = new DefaultParkingStrategy();
    }

    @Test
    void shouldParkCarWhenLotWithUnderCapacityFound() {
        given(lotA.capacityPercentage()).willReturn(0.80);
        given(lotB.capacityPercentage()).willReturn(0.79);

        subject.park(car, parkingLots);

        verify(lotB).park(car);
    }

}