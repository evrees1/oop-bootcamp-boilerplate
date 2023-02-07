package oop.measurements;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.math.BigDecimal;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FeetToMetresConverterTest {

    private final FeetToMetresConverter subject = new FeetToMetresConverter();

    @ParameterizedTest
    @MethodSource("provideTestInput")
    public void itShouldReturnMetresForFeetInput(int feet, double expected) {
        BigDecimal metres = subject.convert(feet);

        assertEquals(expected, metres.doubleValue());
    }


    private static Stream<Arguments> provideTestInput() {
        return Stream.of(
                Arguments.of(5, 1.5239),
                Arguments.of(1, 0.3048)
        );
    }

}