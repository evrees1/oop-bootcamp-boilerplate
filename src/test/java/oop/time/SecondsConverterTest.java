package oop.time;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SecondsConverterTest {

    @Test
    public void itShouldReturnErrorForNegativeValue() {
        var actual = SecondsConverter.convert(-1);

        assertEquals("Invalid input", actual);
    }

    @ParameterizedTest
    @MethodSource("testInput")
    void itShouldReturnConvertedSeconds(Integer seconds, String expected) {
        var actual = SecondsConverter.convert(seconds);

        assertEquals(expected, actual);
    }

    @Test
    public void itShouldReturnMaxValueIfSecondsExceedsMaximum() {
        var actual = SecondsConverter.convert(360000);

        assertEquals("99:59:59", actual);

    }

    private static Stream<Arguments> testInput() {
        return Stream.of(
                Arguments.of(61, "00:01:01"),
                Arguments.of(86399 , "23:59:59"),
                Arguments.of(86401 , "24:00:01"),
                Arguments.of(5, "00:00:05"),
                Arguments.of(359999, "99:59:59")
        );
    }


}