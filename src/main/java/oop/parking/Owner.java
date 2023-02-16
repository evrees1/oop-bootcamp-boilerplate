package oop.parking;

import oop.parking.model.ParkingOccupancyState;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class Owner implements PropertyChangeListener {
    public static final double LOW_OCCUPANCY_LIMIT = 0.20;
    public static final double HIGH_OCCUPANCY_LIMIT = 0.75;
    private boolean highOccupancyAlert;
    private boolean lowOccupancyAlert;

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        ParkingOccupancyState updatedState = (ParkingOccupancyState) evt.getNewValue();
        evaluateStatus(updatedState.getOccupancyPercentage());
    }

    private void evaluateStatus(double updatedCapacity) {
        if (updatedCapacity >= HIGH_OCCUPANCY_LIMIT) {
            highOccupancyAlert = true;
        } else if (updatedCapacity <= LOW_OCCUPANCY_LIMIT) {
            lowOccupancyAlert = true;
        } else {
            highOccupancyAlert = false;
            lowOccupancyAlert = false;
        }
    }

    public boolean isHighOccupancyAlerted() {
        return highOccupancyAlert;
    }

    public boolean isLowOccupancyAlerted() {
        return lowOccupancyAlert;
    }

}