package oop.parking;

import oop.parking.model.Car;
import oop.parking.model.ParkingException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
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
    void findLotWithCarShouldReturnLotWhenLotWithCarFound() {
        given(lotA.contains(car)).willReturn(false);
        given(lotB.contains(car)).willReturn(true);

        ParkingLot actual = subject.findLotWith(car);

        assertEquals(lotB, actual);
    }

    @Test
    void findLotWithCarShouldThrowExceptionWhenLotWithCarNotFound() {
        given(lotA.contains(car)).willReturn(false);
        given(lotB.contains(car)).willReturn(false);
        given(lotC.contains(car)).willReturn(false);

        assertThrows(ParkingException.class, () -> subject.findLotWith(car));
    }

}