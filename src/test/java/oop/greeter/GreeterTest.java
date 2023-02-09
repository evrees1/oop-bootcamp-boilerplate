package oop.greeter;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GreeterTest {

    private Greeter subject;

    @BeforeEach
    void setUp() {
        subject = new Greeter("15:00");
    }

    @Test
    public void itShouldReturnHelloName() {
        String name = "Alice";
        String actual = subject.greet(name);

        assertEquals("Hello Alice", actual);
    }

    @Test
    public void itShouldTrimTheInput() {
        String name = "   Bob   ";
        String actual = subject.greet(name);

        assertEquals("Hello Bob", actual);
    }

    @Test
    public void itShouldCapitalizeName() {
        String name = "ted";
        String actual = subject.greet(name);

        assertEquals("Hello Ted", actual);
    }

    @ParameterizedTest
    @ValueSource(strings = {"06:00:01","12:00:00"})
    public void itShouldChangeMessageInTheMorning(String time) {
        subject = new Greeter(time);

        String name = "Bill";
        String actual = subject.greet(name);

        assertEquals("Good morning Bill", actual);
    }

    @ParameterizedTest
    @ValueSource(strings = {"18:00:01","22:00:00"})
    public void itShouldChangeMessageInTheEvening(String time) {
        subject = new Greeter(time);

        String name = "Philis";
        String actual = subject.greet(name);

        assertEquals("Good evening Philis", actual);
    }

    @ParameterizedTest
    @ValueSource(strings = {"22:00:01","06:00:00"})
    public void itShouldChangeMessageInTheNightTime(String time) {
        subject = new Greeter(time);

        String name = "Marge";
        String actual = subject.greet(name);

        assertEquals("Good night Marge", actual);
    }

}
