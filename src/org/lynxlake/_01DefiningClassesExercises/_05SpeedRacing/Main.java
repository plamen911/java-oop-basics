// https://judge.softuni.bg/Contests/Practice/Index/230#4
package org.lynxlake._01DefiningClassesExercises._05SpeedRacing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        LinkedHashMap<String, Car> carList = new LinkedHashMap<>();

        int n = Integer.valueOf(reader.readLine());
        for (int i = 0; i < n; i++) {
            String[] params = reader.readLine().split("\\s+");
            String carModel = params[0];
            double fuelAmount = Double.valueOf(params[1]);
            double fuelCostForKm = Double.valueOf(params[2]);
            Car car = new Car(carModel, fuelAmount, fuelCostForKm);
            carList.put(carModel, car);
        }

        String command = reader.readLine();
        while (!command.equalsIgnoreCase("End")) {
            String[] params = command.split("\\s+");
            String carModel = params[1];
            double amountOfKm = Double.valueOf(params[2]);

            if (carList.containsKey(carModel)) {
                carList.get(carModel).drive(amountOfKm);
            }

            command = reader.readLine();
        }

        for (Map.Entry<String, Car> entry: carList.entrySet()) {
            entry.getValue().driveReport();
        }

    }
}
