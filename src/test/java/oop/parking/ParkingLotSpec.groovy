package oop.parking

import oop.parking.domain.Car
import spock.lang.Specification

import static org.junit.jupiter.api.Assertions.*

class ParkingLotSpec extends Specification {

    var subject = new ParkingLot(1)

    def "should park car"() {
        given:
        Car car = new Car("ABC-123")

        when:
        subject.parkCar(car);

        then:
        assertTrue(subject.contains(car))
    }

    def "should not park car when full"() {
        given:
        subject.parkCar(new Car("A"))

        and:
        Car anotherCar = new Car("B")

        when:
        subject.parkCar(anotherCar);

        then:
        assertFalse(subject.contains(anotherCar))
    }

    def "should return true when lot has capacity"() {
        when:
        boolean actual = subject.hasFreeSlots()

        then:
        assertTrue(actual)
    }

    def "should return false when lot not has capacity"() {
        given:
        subject.parkCar(new Car("A"))

        when:
        boolean actual = subject.hasFreeSlots()

        then:
        assertFalse(actual)
    }

    def "should return #expected when capacity is #capacity and #spacesInUse spaces are in use"() {
        given:
        subject = new ParkingLot(capacity)

        and:
        spacesInUse.times {
            subject.parkCar(new Car("abc"))
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
}
