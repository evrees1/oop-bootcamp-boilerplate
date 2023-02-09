package oop.measurements;

import oop.measurements.Gallon;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.math.BigDecimal;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class GallonTest {

    @ParameterizedTest
    @MethodSource("provideTestInput")
    public void itShouldConvertGallonsToLitres(double value, double expected) {
        Gallon subject = new Gallon(value);

        BigDecimal litres = subject.toLitres();

        assertEquals(expected, litres.doubleValue());
    }

    private static Stream<Arguments> provideTestInput() {
        return Stream.of(
                Arguments.of(4.0, 15.1416),
                Arguments.of(5.0, 18.927)
        );
    }

}