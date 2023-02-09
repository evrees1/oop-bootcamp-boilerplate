package oop.measurements;

import oop.measurements.Feet;
import oop.measurements.Metre;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class FeetTest {

    @ParameterizedTest
    @MethodSource("provideTestInput")
    public void toMetresShouldReturnMetresForFeetInput(int feetValue, double expected) {
        Feet subject = new Feet(feetValue);

        Metre metre = subject.toMetres();

        assertEquals(expected, metre.value());
    }


    private static Stream<Arguments> provideTestInput() {
        return Stream.of(
                Arguments.of(5, 1.5239),
                Arguments.of(1, 0.3048)
        );
    }

}