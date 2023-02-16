package oop.parking;

import oop.parking.domain.Car;

import java.beans.PropertyChangeSupport;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

public class ParkingLot {

    private static final int CAPACITY_CALCULATION_SCALE = 2;

    private String id;
    private PropertyChangeSupport propertyChangeSupport;
    private final int capacity;
    private final List<Car> parkedCars = new ArrayList<>();
    private boolean acceptsHandicapped;

    public ParkingLot(int capacity) {
        this.capacity = capacity;
    }

    public ParkingLot() {
        this(5);
    }

    public ParkingLot(String id, int capacity, boolean acceptsHandicapped, Owner owner) {
        this.id = id;
        this.capacity = capacity;
        this.acceptsHandicapped = acceptsHandicapped;

        propertyChangeSupport = new PropertyChangeSupport(this);
        propertyChangeSupport.addPropertyChangeListener(owner);
    }

    public void parkCar(Car newCar) {
        if (this.hasFreeSlots()) {
//            double capacityBefore = capacityPercentage();
            parkedCars.add(newCar);
//            §.firePropertyChange("capacityChanged", capacityBefore, capacityPercentage());
        }
    }

    public List<Car> getParkedCars() {
        return parkedCars;
    }

    public boolean retrieveCar(Car car) {
        return parkedCars.remove(car);
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
