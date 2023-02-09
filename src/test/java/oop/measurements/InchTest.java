package oop.measurements;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class InchTest {

    @ParameterizedTest
    @MethodSource("additionInput")
    public void addShouldAddInchesValue(double inchA, double inchB, double expected) {
        Inch subject = new Inch(inchA);
        Inch moreInches = new Inch(inchB);

        Inch actual = subject.add(moreInches);

        assertEquals(expected, actual.value());
    }

    @ParameterizedTest
    @MethodSource("addingMetresInput")
    public void addShouldShouldAddMetres(double inchValue, double metreValue, double expected) {
        Inch subject = new Inch(inchValue);
        Metre metre = new Metre(metreValue);

        Inch actual = subject.add(metre);

        assertEquals(expected, actual.value());
    }

    @ParameterizedTest
    @MethodSource("convertToYardInput")
    public void toYardsShouldConvertInchesToYards(double value, double expected) {
        Inch subject = new Inch(value);

        Yard yards = subject.toYards();

        assertEquals(expected, yards.doubleValue());
    }

    private static Stream<Arguments> additionInput() {
        return Stream.of(
                Arguments.of(5, 5, 10),
                Arguments.of(1.5, 2, 3.5)
        );
    }

    private static Stream<Arguments> addingMetresInput() {
        return Stream.of(
                Arguments.of(2, 1, 41.37008),
                Arguments.of(4, 1, 43.37008)
        );
    }

    private static Stream<Arguments> convertToYardInput() {
        return Stream.of(
                Arguments.of(1, 0.0278),
                Arguments.of(5, 0.1389),
                Arguments.of(2.5, 0.0694)
        );
    }

}