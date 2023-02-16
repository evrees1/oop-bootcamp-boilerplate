package oop.parking.model;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class ParkingOccupancyState {
    private static final int CAPACITY_CALCULATION_SCALE = 2;
    private final int maxCapacity;
    private final int currentOccupancy;

    public ParkingOccupancyState(int maxCapacity, int currentOccupancy) {
        this.maxCapacity = maxCapacity;
        this.currentOccupancy = currentOccupancy;
    }

    public double getOccupancyPercentage() {
        return BigDecimal.valueOf(currentOccupancy)
                .divide(BigDecimal.valueOf(maxCapacity), CAPACITY_CALCULATION_SCALE, RoundingMode.HALF_UP)
                .doubleValue();
    }

    @Override
    public String toString() {
        return "ParkingOccupancyState{" +
                "maxCapacity=" + maxCapacity +
                ", currentOccupancy=" + currentOccupancy +
                '}';
    }


    // TODO create root class or default interface with the first two statements
    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ParkingOccupancyState other)) {
            return false;
        }
        return this.maxCapacity == other.maxCapacity &&
                this.currentOccupancy == other.currentOccupancy;
    }

    //    public static ParkingCapacityChangeEvent getEventValue(PropertyChangeEvent event) {
//        return (ParkingCapacityChangeEvent) event.getNewValue();
//    }
}
