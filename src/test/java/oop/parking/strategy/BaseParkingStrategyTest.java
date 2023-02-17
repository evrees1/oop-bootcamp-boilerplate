package oop.parking.strategy;

import oop.parking.ParkingLot;
import oop.parking.ParkingLots;
import oop.parking.ParkingStrategy;
import oop.parking.model.Car;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;

public class BaseParkingStrategyTest {

    protected ParkingStrategy subject;
    @Mock
    protected ParkingLot lotA;
    @Mock
    protected ParkingLot lotB;
    @Mock
    protected ParkingLot lotC;
    @Mock
    protected Car car;

    protected ParkingLots parkingLots;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
//        Mockito.mockitoSession().initMocks(this)
//                .strictness(Strictness.STRICT_STUBS) // TODO - not working, fix it
//                .startMocking();

        parkingLots = new ParkingLots(List.of(lotA, lotB, lotC));
    }

    void verifyNoParks() {
        verify(lotB, never()).park(any());
        verify(lotA, never()).park(any());
        verify(lotC, never()).park(any());

    }
}
