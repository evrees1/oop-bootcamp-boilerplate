package oop.greeter;

import java.time.LocalTime;

public class Night implements TimePeriod {

    private static final LocalTime PERIOD_START = LocalTime.parse("22:00:00");
    private static final LocalTime PERIOD_END = LocalTime.parse("06:00:01");

    @Override
    public boolean isMatch(String time) {
        LocalTime localTime = LocalTime.parse(time);
        return localTime.isAfter(PERIOD_START) ||
                localTime.isBefore(PERIOD_END);
    }

    @Override
    public String title() {
        return "Good night";
    }
}
