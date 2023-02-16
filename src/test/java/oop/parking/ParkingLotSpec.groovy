package oop.parking

import oop.parking.builder.ParkingLotBuilder
import oop.parking.model.Car
import oop.parking.model.ParkingOccupancyState
import spock.lang.Specification

import java.beans.PropertyChangeSupport

import static oop.parking.ParkingLot.EVENT_NAME
import static org.junit.jupiter.api.Assertions.*

class ParkingLotSpec extends Specification {

    PropertyChangeSupport propertyChangeSupport = Mock()
    ParkingLot subject = createParkingLot()

    def setup() {
        subject.setPropertyChangeSupport(propertyChangeSupport);
    }

    def "should park car"() {
        given:
        Car car = new Car("ABC-123")

        when:
        subject.park(car)

        then:
        assertTrue(subject.contains(car))

        and:
        1 * propertyChangeSupport.firePropertyChange(
                EVENT_NAME,
                new ParkingOccupancyState(2, 0),
                new ParkingOccupancyState(2, 1))
    }

    def "should return true when lot has capacity"() {
        when:
        boolean actual = subject.hasFreeSlots()

        then:
        assertTrue(actual)
    }

    def "should return false when lot not has capacity"() {
        given:
        subject.park(new Car("A"))
        subject.park(new Car("B"))

        when:
        boolean actual = subject.hasFreeSlots()

        then:
        assertFalse(actual)
    }

    def "should return #expected when capacity is #capacity and #spacesInUse spaces are in use"() {
        given:
        subject = createParkingLot(capacity)

        and:
        spacesInUse.times {
            subject.park(new Car("abc"))
        }

        when:
        double actual = subject.capacityPercentage()

        then:
        assertEquals(expected, actual)

        where:
        capacity | spacesInUse | expected
        5        | 4           | 0.8
        5        | 3           | 0.6
        11       | 8           | 0.73
        13       | 8           | 0.62
        79       | 71          | 0.90
    }

    def createParkingLot(int capacity = 2) {
        ParkingLotBuilder.builder()
                .withOwner(new Owner())
                .withCapacity(capacity)
                .build()
    }
}
