package oop.measurements.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class CelsiusTest {

    @ParameterizedTest
    @MethodSource("provideTestInput")
    public void itShouldConvertToFahrenheit(double celsiusValue, double expected) {
        double fahrenheit = new Celsius(celsiusValue).convertToFahrenheit();

        assertEquals(expected, fahrenheit);
    }

    private static Stream<Arguments> provideTestInput() {
        return Stream.of(
                Arguments.of(26.6667, 80),
                Arguments.of(200, 392)
        );
    }


}