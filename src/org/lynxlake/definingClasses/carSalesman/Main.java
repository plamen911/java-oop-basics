// https://judge.softuni.bg/Contests/Practice/Index/230#6
package org.lynxlake.definingClasses.carSalesman;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        // Information about the engines
        int n = Integer.parseInt(reader.readLine());
        HashMap<String, Engine> engineList = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String line = reader.readLine().trim();
            String[] params = line.split("\\s+");

            String model = params[0].trim();
            String power = params[1].trim();

            Engine engine = null;
            if(params.length == 2) {
                engine = new Engine(model, power);
            } else if (params.length == 3) {
                String what = params[2].trim();
                String displacement = "n/a";
                String efficiency = "n/a";
                if (isNumeric(what)) {
                    displacement = what;
                } else {
                    efficiency = what;
                }
                engine = new Engine(model, power, displacement, efficiency);
            } else if (params.length == 4) {
                String displacement = params[2].trim();
                String efficiency = params[3].trim();
                engine = new Engine(model, power, displacement, efficiency);
            }
            engineList.put(model, engine);
        }

        // Information about the cars
        int m = Integer.parseInt(reader.readLine());
        for (int i = 0; i < m; i++) {
            String[] params = reader.readLine().trim().split("\\s+");
            String model = params[0].trim();
            String carEngine = params[1].trim();

            Car car = null;
            Engine engine = null;
            if (engineList.containsKey(carEngine)) {
                engine = engineList.get(carEngine);
            }
            if (params.length == 4) {
                String weight = params[2].trim();
                String color = params[3].trim();
                car = new Car(model, engine, weight, color);
            } else if (params.length == 3) {
                String what = params[2].trim();
                String weight = "n/a";
                String color = "n/a";
                if (isNumeric(what)) {
                    weight = what;
                } else {
                    color = what;
                }
                car = new Car(model, engine, weight, color);
            } else if(params.length == 2) {
                car = new Car(model, engine);
            }

            if (car == null) {
                System.out.println("car " + model + " is null...");
            }
            if (engine == null) {
                System.out.println("engine " + carEngine + " is null...");
            }

            if (car != null && engine != null) {
                System.out.println(car.getModel() + ":");
                System.out.println("  " + car.getEngine().getModel() + ":");
                System.out.println("    Power: " + car.getEngine().getPower());
                System.out.println("    Displacement: " + car.getEngine().getDisplacement());
                System.out.println("    Efficiency: " + car.getEngine().getEfficiency());
                System.out.println("  Weight: " + car.getWeight());
                System.out.println("  Color: " + car.getColor());
            }
        }

        reader.close();
    }

    private static boolean isNumeric(String num) {
        try {
            int n = Integer.parseInt(num);
            return true;
        } catch (NumberFormatException ex) {
            return false;
        }
    }
}
