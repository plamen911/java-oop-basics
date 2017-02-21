// https://judge.softuni.bg/Contests/Practice/Index/231#2
package org.lynxlake._03StaticMembers._03TemperatureConverter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String line = reader.readLine().trim();

        List<String> result = new ArrayList<>();

        while (!line.equalsIgnoreCase("End")) {
            String[] params = line.split("\\s+");
            int temperature = Integer.parseInt(params[0]);
            String unit = params[1];

            result.add(TemparatureConverter.convert(temperature, unit));

            line = reader.readLine().trim();
        }
        reader.close();

        for (int i = 0; i < result.size(); i++) {
            System.out.println(result.get(i));
        }
    }
}
