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


    @ParameterizedTest
    @MethodSource("provideRectangleDimensions")
    public void itShouldComputeArea(int width, int length, int expected) {
        Rectangle rectangle = new Rectangle(length, width);

        int area = rectangle.computeArea();

        assertEquals(area, expected);
    }

    @Test
    public void itShouldReturnPerimeter() {


    }

    private static Stream<Arguments> provideRectangleDimensions() {
        return Stream.of(
                Arguments.of(5, 10, 50),
                Arguments.of(10, 10, 100)
        );
    }
}