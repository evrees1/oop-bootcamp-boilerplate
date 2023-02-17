package oop.parking.chain;

import oop.parking.ParkingLot;
import oop.parking.ParkingLots;
import oop.parking.ParkingStrategy;
import oop.parking.model.Car;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;

class DefaultAssistantTest {

    private DefaultAssistant subject;

    @Mock
    private HighEndAssistant highEndAssistant;

    @Mock
    private Car car;
    @Mock
    private ParkingStrategy parkingStrategy;

    @Mock
    private ParkingLots parkingLots;
    @Mock
    private ParkingLot lot;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        subject = new DefaultAssistant(parkingLots);
    }

    @Test
    void parkShouldUseReturnedParkingStrategy() {
        given(car.findStrategyToPark()).willReturn(parkingStrategy);

        subject.park(car, parkingLots);

        verify(parkingStrategy).park(car, parkingLots);
    }

    @Test
    void parkShouldDelegateHighEndAssistantWhenCarHighEnd() {
        subject.addAssistant(highEndAssistant);
        given(car.isHighEnd()).willReturn(true);
        given(car.findStrategyToPark()).willReturn(parkingStrategy);

        subject.park(car, parkingLots);

        verify(highEndAssistant).park(car, parkingLots);
    }

    @Test
    void parkShouldDoNothingWhenCarHighEndAndNoDelegateFound() {
        given(car.isHighEnd()).willReturn(true);

        subject.park(car, parkingLots);

        verify(parkingLots, never()).findLotWith(any());
    }

    @Test
    void retrieveShouldRetrieveFromLotWhenLotWithCarFound() {
        given(parkingLots.findLotWith(car)).willReturn(Optional.of(lot));

        subject.retrieve(car);

        verify(lot).retrieve(car);
    }

    @Test
    void retrieveShouldNotWhenCarNotFound() {
        given(parkingLots.findLotWith(car)).willReturn(Optional.empty());

        subject.retrieve(car);

        verify(lot, never()).retrieve(any());
    }
}