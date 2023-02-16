package oop.time

import spock.lang.Specification

import static org.junit.jupiter.api.Assertions.assertEquals

class SecondsConverterSpec extends Specification {

//    @Unroll
    def "convert should return #expected when seconds is #seconds"() {
        when:
            def actual = SecondsConverter.convert(seconds)

        then:
            assertEquals(expected, actual)

        where:
            seconds | expected
            61      | "00:01:01"
            86399   | "23:59:59"
            86401   | "24:00:01"
            5       | "00:00:05"
            359999  | "99:59:59"





    }
}
