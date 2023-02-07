package oop.measurements;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.math.BigDecimal;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class InchToYardConverterTest {

    @ParameterizedTest
    @MethodSource("inchesToYardsProvider")
    public void itShouldConvertInchesToYards(double inch, double expected) {
        BigDecimal yards = new InchToYardConverter().convert(inch);

        assertEquals(expected, yards.doubleValue());
    }

    private static Stream<Arguments> inchesToYardsProvider() {
        return Stream.of(
                Arguments.of(1, 0.0278),
                Arguments.of(5, 0.1389),
                Arguments.of(2.5, 0.0694)
        );
    }
}