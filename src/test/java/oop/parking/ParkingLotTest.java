package oop.parking;

import oop.parking.builder.ParkingLotBuilder;
import oop.parking.model.Car;
import oop.parking.model.ParkingOccupancyState;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.beans.PropertyChangeSupport;

import static oop.parking.ParkingLot.EVENT_NAME;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.verify;

public class ParkingLotTest {

    private ParkingLot subject;
    private Owner owner = new Owner();

    @Mock
    private PropertyChangeSupport propertyChangeSupport;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);

        this.subject = ParkingLotBuilder.builder()
                .withOwner(owner)
                .withCapacity(2)
                .build();

        subject.setPropertyChangeSupport(propertyChangeSupport);
    }

    @Test
    void parkShouldParkCar() {
        Car car = new Car("ABC-123");
        subject.park(car);

        assertTrue(subject.contains(car));

        ParkingOccupancyState currentValue = new ParkingOccupancyState(2, 0);
        ParkingOccupancyState updatedValue = new ParkingOccupancyState(2, 1);

        verify(propertyChangeSupport).firePropertyChange(EVENT_NAME, currentValue, updatedValue);
    }

    @Test
    void retrieveShouldRetrieveCar() {
        Car car = new Car("ABC-123");
        subject.park(car);

        subject.retrieve(car);
        assertFalse(subject.getParkedCars().contains(car));

        ParkingOccupancyState currentValue = new ParkingOccupancyState(2, 1);
        ParkingOccupancyState updatedValue = new ParkingOccupancyState(2, 0);
        verify(propertyChangeSupport).firePropertyChange(EVENT_NAME, currentValue, updatedValue);
    }

    @Test
    void containsShouldReturnTrueWhenContainsCar() {
        final Car car = new Car("ABC-123");
        subject.park(car);

        assertTrue(subject.contains(car));
    }

    @Test
    void capacityPercentageShouldReturnPercentageOfCapacityInUse() {
        subject.park(new Car("1"));

        assertEquals(subject.capacityPercentage(), 0.5);
    }
}
