package oop.greeter;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertTrue;

class EveningTest {

    private final Evening subject = new Evening();

    @ParameterizedTest
    @ValueSource(strings = {"18:00:01","22:00:00"})
    public void itShouldChangeMessageInTheEvening(String time) {
        assertTrue(subject.isMatch(time));
    }

}