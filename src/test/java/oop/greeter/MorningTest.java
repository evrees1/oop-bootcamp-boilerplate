package oop.greeter;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertTrue;

class MorningTest {

    private final Morning subject = new Morning();

    @ParameterizedTest
    @ValueSource(strings = {"06:00:01","12:00:00"})
    public void itShouldChangeMessageInTheMorning(String time) {
        assertTrue(subject.isMatch(time));
    }
}