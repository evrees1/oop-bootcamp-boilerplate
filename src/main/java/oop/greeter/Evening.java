package oop.greeter;

import java.time.LocalTime;

public class Evening implements TimePeriod {

    private static final LocalTime PERIOD_START = LocalTime.parse("18:00:00");
    private static final LocalTime PERIOD_END = LocalTime.parse("22:00:01");

    @Override
    public boolean isMatch(String time) {
        LocalTime localTime = LocalTime.parse(time);
        return localTime.isAfter(PERIOD_START) &&
                localTime.isBefore(PERIOD_END);
    }

    @Override
    public String title() {
        return "Good evening";
    }
}
