package oop.parking.strategy

import oop.parking.ParkingLot
import oop.parking.model.Car
import oop.parking.ParkingLots
import spock.lang.Specification

class DefaultParkingStrategySpec extends Specification {

    DefaultParkingStrategy subject = new DefaultParkingStrategy()
    ParkingLot lotA = Mock()
    ParkingLot lotB = Mock()
    Car car = new Car("abc")


    def "should not park car when no lot with capacity found"() {
        given:
        lotA.capacityPercentage() >> 80
        lotB.capacityPercentage() >> 81

        when:
        subject.park(car, new ParkingLots(List.of(lotA, lotB)))

        then:
        0 * lotA.park(car)
        0 * lotB.park(car)
    }


}
