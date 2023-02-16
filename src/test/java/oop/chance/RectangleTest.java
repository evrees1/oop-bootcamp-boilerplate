package oop.chance;

import oop.modelrectangle.Rectangle;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(Parameterized.class)
class RectangleTest {


    @ParameterizedTest
    @MethodSource("data")
    public void itShouldReturnArea(int width, int length, int expected) {
        Rectangle rectangle = new Rectangle(length, width);

        int area = rectangle.computeArea();

        assertEquals(area, expected);
    }

    @ParameterizedTest
    @MethodSource("provideRectangleDimensionsForArea")
    public void itShouldReturnPerimeter(int width, int length, int expected) {


    }

    @Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
                { 5, 10, 50 }, {10, 10, 100}
        });
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