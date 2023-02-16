package oop.parking.domain

import oop.parking.builder.CarBuilder
import oop.parking.strategy.DefaultParkingStrategy
import oop.parking.strategy.LargeCarParkingStrategy
import oop.parking.strategy.LargeHandicapParkingStrategy
import spock.lang.Specification

import static org.junit.jupiter.api.Assertions.assertInstanceOf

class CarSpec extends Specification {

    def "Should return #expected when isLarge is #isLarge and isHandicapped is #isHandicapped"() {
        given:
        Car subject = new Car("abc", isLarge, isHandicapped)

        when:
        var actual = subject.findStrategyToPark()

        then:
        assertInstanceOf(expected, actual);

        where:
        isLarge | isHandicapped | expected
        false   | false         | DefaultParkingStrategy.class
        true    | false         | LargeCarParkingStrategy.class
        true    | true          | LargeHandicapParkingStrategy.class


    }
}
