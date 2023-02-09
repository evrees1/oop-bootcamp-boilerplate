package oop.measurements;

import oop.measurements.Inch;
import oop.measurements.Metre;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.math.BigDecimal;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class MetreTest {

    @ParameterizedTest
    @MethodSource("addMetresInput")
    public void addShouldAddMetres(double valueA, double valueB, double expected) {
        Metre subject = new Metre(valueA);
        Metre moreMetres = new Metre(valueB);

        Metre actual = subject.add(moreMetres);

        assertEquals(new Metre(expected), actual);
    }

    @ParameterizedTest
    @MethodSource("convertToInchesInput")
    public void toInchesShouldReturnValueInInches(double value, double expected) {
        Metre subject = new Metre(value);

        Inch inches = subject.toInches();

        assertEquals(expected, inches.value());
    }

    @ParameterizedTest
    @MethodSource("convertToCentimetresInput")
    public void itShouldConvertMetresToCentimetres(double value, double expected) {
        Metre subject = new Metre(value);

        BigDecimal centimetres = subject.toCentimetres();

        assertEquals(expected, centimetres.doubleValue());
    }

    private static Stream<Arguments> addMetresInput() {
        return Stream.of(
                Arguments.of(5, 5, 10),
                Arguments.of(1.5, 2, 3.5)
        );
    }

    private static Stream<Arguments> convertToInchesInput() {
        return Stream.of(
                Arguments.of(5, 196.8504),
                Arguments.of(1, 39.37008)
        );
    }

    private static Stream<Arguments> convertToCentimetresInput() {
        return Stream.of(
                Arguments.of(2, 200),
                Arguments.of(1, 100),
                Arguments.of(0.5, 50)
        );
    }
}