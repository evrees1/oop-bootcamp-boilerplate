package oop.parking;

import oop.parking.model.Car;
import oop.parking.model.ParkingOccupancyState;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

public class ParkingLot {

    private static final int CAPACITY_CALCULATION_SCALE = 2;
    static final String EVENT_NAME = "capacityChanged";

    private final int capacity;
    private final List<Car> parkedCars = new ArrayList<>();
    private boolean acceptsHandicapped;
    private PropertyChangeSupport propertyChangeSupport;

    public ParkingLot(int capacity) {
        this.capacity = capacity;
    }

    public ParkingLot() {
        this(5);
        propertyChangeSupport = new PropertyChangeSupport(this);
    }

    public ParkingLot(int capacity, boolean acceptsHandicapped, Owner owner) {
        this.capacity = capacity;
        this.acceptsHandicapped = acceptsHandicapped;

        propertyChangeSupport = new PropertyChangeSupport(this);
        propertyChangeSupport.addPropertyChangeListener(owner);
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        propertyChangeSupport.addPropertyChangeListener(listener);
    }

    public void setPropertyChangeSupport(PropertyChangeSupport propertyChangeSupport) {
        this.propertyChangeSupport = propertyChangeSupport;
    }

    public List<Car> getParkedCars() {
        return parkedCars;
    }

    public void park(Car car) {
        ParkingOccupancyState currentValue = new ParkingOccupancyState(capacity, parkedCars.size());
        parkedCars.add(car);
        ParkingOccupancyState updatedValue = new ParkingOccupancyState(capacity, parkedCars.size());
        propertyChangeSupport.firePropertyChange(EVENT_NAME, currentValue, updatedValue);
    }

    public void retrieve(Car car) {
        ParkingOccupancyState currentValue = new ParkingOccupancyState(capacity, parkedCars.size());
        parkedCars.remove(car);
        ParkingOccupancyState updatedValue = new ParkingOccupancyState(capacity, parkedCars.size());
        propertyChangeSupport.firePropertyChange(EVENT_NAME, currentValue, updatedValue);
    }

    public boolean hasFreeSlots() {
        return parkedCars.size() < this.capacity;
    }

    public double capacityPercentage() {
        return BigDecimal.valueOf(parkedCars.size())
                .divide(BigDecimal.valueOf(this.capacity), CAPACITY_CALCULATION_SCALE, RoundingMode.HALF_UP)
                .doubleValue();
    }

    public boolean isAcceptsHandicapped() {
        return acceptsHandicapped;
    }

    public boolean contains(Car car) {
        return parkedCars.contains(car);
    }
}
