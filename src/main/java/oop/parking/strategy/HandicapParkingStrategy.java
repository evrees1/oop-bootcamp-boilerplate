package oop.parking.strategy;

import oop.parking.ParkingLot;

public class HandicapParkingStrategy extends DefaultParkingStrategy {

    @Override
    protected boolean meetsParkingCriteria(ParkingLot parkingLot) {
        return parkingLot.hasFreeSlots() && parkingLot.isAcceptsHandicapped();
    }
}
