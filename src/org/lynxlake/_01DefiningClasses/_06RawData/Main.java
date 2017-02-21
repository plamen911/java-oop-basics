// https://judge.softuni.bg/Contests/Practice/Index/230#5
package org.lynxlake._01DefiningClasses._06RawData;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());

        List<Car> cars = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String[] params = reader.readLine().trim().split("\\s+");
            String carModel = params[0];
            int engineSpeed = Integer.parseInt(params[1]);
            int enginePower = Integer.parseInt(params[2]);
            int cargoWeight = Integer.parseInt(params[3]);
            String cargoType = params[4];
            double tire1Pressure = Double.parseDouble(params[5]);
            int tire1Age = Integer.parseInt(params[6]);
            double tire2Pressure = Double.parseDouble(params[7]);
            int tire2Age = Integer.parseInt(params[8]);
            double tire3Pressure = Double.parseDouble(params[9]);
            int tire3Age = Integer.parseInt(params[10]);
            double tire4Pressure = Double.parseDouble(params[11]);
            int tire4Age = Integer.parseInt(params[12]);

            Engine carEngine = new Engine(engineSpeed, enginePower);
            Cargo carCargo = new Cargo(cargoWeight, cargoType);
            Tire[] carTires = {
                    new Tire(tire1Pressure, tire1Age),
                    new Tire(tire2Pressure, tire2Age),
                    new Tire(tire3Pressure, tire3Age),
                    new Tire(tire4Pressure, tire4Age),
            };

            cars.add(new Car(carModel, carEngine, carCargo, carTires));
        }

        String command = reader.readLine().trim();
        reader.close();

        for (Car car : cars) {
            if (command.equalsIgnoreCase("fragile")
                    && car.getCargo().getType().equalsIgnoreCase(command)) {
                for (Tire tire : car.getTires()) {
                    if (tire.getPressure() < 1.0) {
                        System.out.println(car.getModel());
                        break;
                    }
                }
            } else if (command.equalsIgnoreCase("flamable")
                    && car.getCargo().getType().equalsIgnoreCase(command)
                    && car.getEngine().getPower() > 250) {
                System.out.println(car.getModel());
            }
        }
    }
}