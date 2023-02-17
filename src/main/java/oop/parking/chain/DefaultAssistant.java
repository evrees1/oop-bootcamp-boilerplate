package oop.parking.chain;

import com.github.javaparser.ParseException;
import oop.parking.ParkingLot;
import oop.parking.ParkingLots;
import oop.parking.model.Car;

import java.util.ArrayList;
import java.util.Optional;

public class DefaultAssistant extends AbstractParkingAssistant {

    public DefaultAssistant() {}

    public DefaultAssistant(ParkingLots parkingLots) {
        this.parkingLots = parkingLots;
        this.underlings = new ArrayList<>();
    }

    @Override
    public boolean park(Car car, ParkingLots parkingLots) {
        return car.isHighEnd() ?
                findCapableAssistant(car, parkingLots) :
                processPark(car, parkingLots);
    }

    public void retrieve(Car car) {
        parkingLots.findLotWith(car)
                .retrieve(car);
    }
}
