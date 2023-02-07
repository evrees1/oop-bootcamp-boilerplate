package oop.measurements;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.math.BigDecimal;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class MetresToCentimetresConverterTest {

    private MetresToCentimetresConverter subject = new MetresToCentimetresConverter();

    @ParameterizedTest
    @MethodSource("provideTestInput")
    public void itShouldConvertMetresToCentimetres(double metres, double expected) {
        BigDecimal centimetres = subject.convert(metres);

        assertEquals(expected, centimetres.doubleValue());
    }

    private static Stream<Arguments> provideTestInput() {
        return Stream.of(
                Arguments.of(2, 200),
                Arguments.of(1, 100),
                Arguments.of(0.5, 50)
        );
    }

}