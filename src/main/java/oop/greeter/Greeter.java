package oop.greeter;

import java.util.Set;

public class Greeter {

    private static final String DEFAULT = "Hello";

    private final Set<TimePeriod> timePeriods = Set.of(
            new Morning(),
            new Evening(),
            new Night());

    private String time;

    public Greeter(String time) {
        this.time = time;
    }

    public String greet(String name) {
        String trimmedName = name.trim();
        String capitalizedName = capitalizeFirstLetter(trimmedName);
        return greetingByTime() + " " + capitalizedName;
    }

    private String capitalizeFirstLetter(String value) {
        return value.substring(0, 1).toUpperCase() + value.substring(1);
    }

    private String greetingByTime() {
        return timePeriods.stream()
                .filter(timePeriod -> timePeriod.isMatch(time))
                .map(TimePeriod::title)
                .findAny()
                .orElse(DEFAULT);

    }
}
