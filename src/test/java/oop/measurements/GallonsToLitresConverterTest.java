package oop.measurements;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.math.BigDecimal;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GallonsToLitresConverterTest {

    private GallonsToLitresConverter subject = new GallonsToLitresConverter();

    @ParameterizedTest
    @MethodSource("provideTestInput")
    public void itShouldConvertGallonsToLitres(double gallons, double expected) {
        BigDecimal litres = subject.convert(gallons);

        assertEquals(expected, litres.doubleValue());
    }

    private static Stream<Arguments> provideTestInput() {
        return Stream.of(
                Arguments.of(4.0, 15.1416),
                Arguments.of(5.0, 18.927)
        );
    }
}
