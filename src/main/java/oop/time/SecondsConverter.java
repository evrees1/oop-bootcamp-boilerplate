package oop.time;

public class SecondsConverter {

    private static final int MAX_SECONDS = 359999;
    private static final String MAX_TIME = "99:59:59";
    private static final int SECONDS_IN_HOUR = 3600;
    private static final int MINUTES_IN_HOUR = 60;

    public static String convert(int seconds) {
        if (seconds < 0) {
            return "Invalid input";
        }
        if (seconds > MAX_SECONDS) {
            return MAX_TIME;
        }

        var hours = seconds / SECONDS_IN_HOUR;
        var minutes = (seconds % SECONDS_IN_HOUR) / MINUTES_IN_HOUR;
        seconds = seconds % MINUTES_IN_HOUR;

        return String.format("%02d:%02d:%02d", hours, minutes, seconds);

    }
}
