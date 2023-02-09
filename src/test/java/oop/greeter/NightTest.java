package oop.greeter;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertTrue;

class NightTest {

    public final Night subject = new Night();

    @ParameterizedTest
    @ValueSource(strings = {"22:00:01","06:00:00"})
    public void itShouldChangeMessageInTheNightTime(String time) {
        assertTrue(subject.isMatch(time));
    }

}