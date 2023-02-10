package oop.parking;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class Owner implements PropertyChangeListener {
    public static final double LOW_OCCUPANCY_LIMIT = 0.20;
    public static final double HIGH_OCCUPANCY_LIMIT = 0.75;
    private boolean overcrowdedAlert;
    private boolean lowOccupancyAlert;

    public void propertyChange(PropertyChangeEvent evt) {
        this.overcrowdedAlert = (double) evt.getNewValue() > HIGH_OCCUPANCY_LIMIT;
        this.lowOccupancyAlert = (double) evt.getNewValue() < LOW_OCCUPANCY_LIMIT;
    }

    public boolean isAlerted() {
        return overcrowdedAlert;
    }

    public boolean isLowOccupancyAlerted() {
        return lowOccupancyAlert;
    }

}