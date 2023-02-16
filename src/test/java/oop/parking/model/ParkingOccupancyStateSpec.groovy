package oop.parking.model

import spock.lang.Specification

import static org.junit.jupiter.api.Assertions.assertEquals

class ParkingOccupancyStateSpec extends Specification {

    def "getOccupancyPercentage should return #expected when capacity is #capacity and occupancy is #occupancy"() {
        given:
        var ParkingOccupancyState subject = new ParkingOccupancyState(capacity, occupancy)

        when:
        var actual = subject.getOccupancyPercentage()

        then:
        assertEquals(expected, actual)

        where:
        capacity    | occupancy | expected
        5           | 4         | 0.8
        5           | 3         | 0.6
        5           | 1         | 0.2
        11          | 8         | 0.73
        13          | 8         | 0.62
        79          | 71        | 0.90

    }
}
