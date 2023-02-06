package oop;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.testng.Assert.assertEquals;

class RectangleTest {

    @Test
    public void itShouldComputeArea() {
        int length = 5;
        int width = 10;
        Rectangle rectangle = new Rectangle(length, width);

        int area = rectangle.computeArea();

        assertEquals(area, 50);
    }

    @ParameterizedTest
    @MethodSource("provideRectangleDimensions")
    public void itShouldComputeAreaWhenSquare(int width, int length, int expected) {
        Rectangle rectangle = new Rectangle(length, width);

        int area = rectangle.computeArea();

        assertEquals(area, expected);
    }

    private static Stream<Arguments> provideRectangleDimensions() {
        return Stream.of(
                Arguments.of(5, 10, 50),
                Arguments.of(10, 10, 100)
        );
    }
}