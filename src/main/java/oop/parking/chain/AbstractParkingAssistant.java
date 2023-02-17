package oop.parking.chain;

import oop.parking.ParkingLots;
import oop.parking.ParkingStrategy;
import oop.parking.model.Car;

import java.util.ArrayList;
import java.util.List;

import static java.util.Collections.emptyList;

public abstract class AbstractParkingAssistant implements ParkingAssistant {

    protected List<ParkingAssistant> underlings = new ArrayList<>();
    protected ParkingLots parkingLots = new ParkingLots(emptyList());


    @Override
    public void setParkingLots(ParkingLots parkingLots) {
        this.parkingLots = parkingLots;
    }

    public void addAssistant(ParkingAssistant assistant) {
        assistant.setParkingLots(parkingLots);
        underlings.add(assistant);
    }

    public boolean processPark(Car car, ParkingLots parkingLots) {
        ParkingStrategy parkingStrategy = car.findStrategyToPark();
        parkingStrategy.park(car, parkingLots);
        return true;
    }

    protected boolean findCapableAssistant(Car car, ParkingLots parkingLots) {
        for (ParkingAssistant pa : underlings) {
            if (pa.park(car, parkingLots)) {
                return true;
            }
        }
        return false;
    }


    public void setUnderlings(List<ParkingAssistant> underlings) {
        this.underlings = underlings;
    }
}
