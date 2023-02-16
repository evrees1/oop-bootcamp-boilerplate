package oop.parking;

import oop.parking.builder.ParkingLotBuilder;
import oop.parking.model.Car;
import oop.parking.model.ParkingOccupancyState;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.beans.PropertyChangeEvent;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class OwnerTest {

    private Owner subject = new Owner();
    
    @Test
    void shouldGiveHighOccupancyAlertWhenThresholdExceeded() {
        PropertyChangeEvent propertyChangeEvent = event(5, 3, 4);

        subject.propertyChange(propertyChangeEvent);

        assertTrue(subject.isHighOccupancyAlerted());
    }

    @Test
    void shouldNotGiveHighOccupancyAlertWhenThresholdNotExceeded() {
        PropertyChangeEvent propertyChangeEvent = event(5, 2, 3);

        subject.propertyChange(propertyChangeEvent);

        assertFalse(subject.isHighOccupancyAlerted());
    }

    @Test
    void shouldGiveLowOccupancyAlertWhenThresholdExceeded() {
        PropertyChangeEvent propertyChangeEvent = event(5, 2, 1);

        subject.propertyChange(propertyChangeEvent);

        assertTrue(subject.isLowOccupancyAlerted());
    }

    @Test
    void shouldNotGiveLowOccupancyAlertWhenThresholdNotExceeded() {
        PropertyChangeEvent propertyChangeEvent = event(5, 3, 2);

        subject.propertyChange(propertyChangeEvent);

        assertFalse(subject.isLowOccupancyAlerted());
    }

    private PropertyChangeEvent event(int maxCapacity, int previous, int current) {
        ParkingOccupancyState previousState = new ParkingOccupancyState(maxCapacity, previous);
        ParkingOccupancyState currentState = new ParkingOccupancyState(maxCapacity, current);

        return new PropertyChangeEvent(new ParkingLot(), "change", previousState, currentState);
    }
}
