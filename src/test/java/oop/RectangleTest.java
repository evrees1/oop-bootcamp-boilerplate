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
    @MethodSource("provideRectangleDimensionsForPerimeter")
    public void itShouldReturnArea(int width, int length, int expected) {
        Rectangle rectangle = new Rectangle(length, width);

        int area = rectangle.computeArea();

        assertEquals(area, expected);
    }

    @ParameterizedTest
    @MethodSource("provideRectangleDimensionsForArea")
    public void itShouldReturnPerimeter(int width, int length, int expected) {


    }

    private static Stream<Arguments> provideRectangleDimensionsForArea() {
        return Stream.of(
                Arguments.of(5, 10, 50),
                Arguments.of(10, 10, 100)
        );
    }

    private static Stream<Arguments> provideRectangleDimensionsForPerimeter() {
        return Stream.of(
                Arguments.of(5, 10, 50),
                Arguments.of(10, 10, 100)
        );
    }
}