package oop.measurements.domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.math.BigDecimal;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class MetreTest {

    @ParameterizedTest
    @MethodSource("provideTestInput")
    public void itShouldAddMetres(double valueA, double valueB, double expected) {
        Metre a = new Metre(valueA);
        Metre b = new Metre(valueB);

        Metre actual = a.plus(b);

        assertEquals(new Metre(expected), actual);
    }

    @ParameterizedTest
    @MethodSource("provideConversionToInches")
    public void itShouldReturnValueInInches(double value, double expected) {
        Inch inches = new Metre(value).convertToInches();

        assertEquals(expected, inches.getValue());
    }


    private static Stream<Arguments> provideTestInput() {
        return Stream.of(
                Arguments.of(5, 5, 10),
                Arguments.of(1.5, 2, 3.5)
        );
    }

    private static Stream<Arguments> provideConversionToInches() {
        return Stream.of(
                Arguments.of(5, 196.8504),
                Arguments.of(1, 39.37008)
        );
    }
}