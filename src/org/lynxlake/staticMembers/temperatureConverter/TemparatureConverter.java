package org.lynxlake.staticMembers.temperatureConverter;

class TemparatureConverter {
    static String convert(int temperature, String unit) {
        if (unit.equalsIgnoreCase("Celsius")) {
            return String.format("%.2f Fahrenheit", (double)(temperature * 9.0 / 5.0 + 32.0));
        } else {
            return String.format("%.2f Celsius", (double)((temperature - 32.0) * 5.0 / 9.0));
        }
    }
}
