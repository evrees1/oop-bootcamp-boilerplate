package oop.parking.strategy;

import oop.parking.ParkingLot;

public class LargeHandicapParkingStrategy extends LargeCarParkingStrategy {

    @Override
    protected boolean meetsParkingCriteria(ParkingLot parkingLot) {
        return parkingLot.hasFreeSlots() && parkingLot.isAcceptsHandicapped();
    }
}
