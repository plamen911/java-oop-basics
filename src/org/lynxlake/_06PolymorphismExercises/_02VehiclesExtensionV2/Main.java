// https://judge.softuni.bg/Contests/Practice/Index/242#1
package org.lynxlake._06PolymorphismExercises._02VehiclesExtensionV2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private static Car car;
    private static Truck truck;
    private static Bus bus;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] params;
        for (int i = 0; i < 3; i++) {
            params = reader.readLine().trim().split("\\s+");
            switch (params[0]) {
                case "Car":
                    try {
                        car = (Car)tryParseVehicle(params);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case "Truck":
                    try {
                        truck = (Truck)tryParseVehicle(params);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case "Bus":
                    try {
                        bus = (Bus)tryParseVehicle(params);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
            }
        }

        int n = Integer.parseInt(reader.readLine());
        for (int i = 0; i < n; i++) {
            String line = reader.readLine();
            String[] input = line.split("\\s+");

            switch (input[0]) {
                case "Drive":
                    try {
                        processDrive(line);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case "DriveEmpty":
                    int distance = Integer.parseInt(input[2]);
                    bus.setFuelConsumptionEmpty();
                    try {
                        if (bus.drive(distance)) {
                            System.out.println("Bus travelled " + distance + " km");
                        } else {
                            System.out.println("Bus needs refueling");
                        }
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case "Refuel":
                    try {
                        processRefuel(line);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
            }
        }

        System.out.printf("Car: %.2f%n", car.getFuelQuantity());
        System.out.printf("Truck: %.2f%n", truck.getFuelQuantity());
        System.out.printf("Bus: %.2f%n", bus.getFuelQuantity());
    }

    private static void processRefuel(String line) throws Exception {
        String[] input = line.trim().split("\\s+");
        String vehicleType = input[1];
        double liters = Double.parseDouble(input[2]);

        switch (vehicleType) {
            case "Car":
                car.refuel(liters);
                break;
            case "Truck":
                truck.refuel(liters);
                break;
            case "Bus":
                bus.refuel(liters);
                break;
        }
    }

    private static void processDrive(String line) throws Exception {
        String[] input = line.trim().split("\\s+");
        String vehicleType = input[1];
        int distance = Integer.parseInt(input[2]);
        boolean canDrive = true;

        switch (vehicleType) {
            case "Car":
                canDrive = car.drive(distance);
                break;
            case "Truck":
                canDrive = truck.drive(distance);
                break;
            case "Bus":
                bus.setFuelConsumptionWithPeople();
                canDrive = bus.drive(distance);
                break;
        }

        if (canDrive) {
            System.out.println(vehicleType + " travelled " + distance + " km");
        } else {
            System.out.println(vehicleType + " needs refueling");
        }
    }

    private static Vehicle tryParseVehicle(String[] params) throws Exception {
        double fuelQuantity = Double.parseDouble(params[1]);
        double fuelConsumption = Double.parseDouble(params[2]);
        double tankCapacity = Double.parseDouble(params[3]);
        switch (params[0]) {
            case "Car":
                return new Car(fuelQuantity, fuelConsumption, tankCapacity);
            case "Truck":
                return new Truck(fuelQuantity, fuelConsumption, tankCapacity);
            default:
                return new Bus(fuelQuantity, fuelConsumption, tankCapacity);
        }
    }
}
