package oop.measurements.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class InchTest {


    @ParameterizedTest
    @MethodSource("provideTestInput")
    public void itShouldAddInches(double inchA, double inchB, double expected) {
        Inch a = new Inch(inchA);
        Inch b = new Inch(inchB);

        Inch actual = a.plus(b);

        assertEquals(new Inch(expected), actual);
    }

    @ParameterizedTest
    @MethodSource("provideInputForAddingMetres")
    public void itShouldShouldAddMetres(double inchValue, double metreValue, double expected) {
        Metre metre = new Metre(metreValue);
        Inch inch = new Inch(inchValue);

        Inch actual = inch.add(metre);

        assertEquals(expected, actual.getValue());
    }


    private static Stream<Arguments> provideTestInput() {
        return Stream.of(
                Arguments.of(5, 5, 10),
                Arguments.of(1.5, 2, 3.5)
        );
    }

    private static Stream<Arguments> provideInputForAddingMetres() {
        return Stream.of(
                Arguments.of(2, 1, 41.37008),
                Arguments.of(4, 1, 43.37008)
        );
    }

}