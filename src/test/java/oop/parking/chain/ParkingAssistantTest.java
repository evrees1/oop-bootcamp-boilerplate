package oop.parking.chain;

import oop.parking.ParkingLots;
import oop.parking.model.Car;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

class ParkingAssistantTest {

    private DefaultAssistant fourth = new DefaultAssistant();
    private DefaultAssistant third = new DefaultAssistant();
    private DefaultAssistant second = new DefaultAssistant();
    private DefaultAssistant boss = new DefaultAssistant();

    @Mock
    private HighEndAssistant highEndAssistant;

    @Mock
    private Car car;
    @Mock
    private ParkingLots parkingLots;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        List<ParkingAssistant> layerC = List.of(fourth, highEndAssistant);
        List<ParkingAssistant> layerB = List.of(second, third);
        boss.setUnderlings(layerB);
        third.setUnderlings(layerC);

        given(car.isHighEnd()).willReturn(true);
    }

    @Test
    void shouldParkHighEndWithHighEndAssistant() {
        boss.park(car, parkingLots);

        verify(highEndAssistant).park(car, parkingLots);
    }
}