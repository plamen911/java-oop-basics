// https://judge.softuni.bg/Contests/Practice/Index/242#1
package org.lynxlake._06PolymorphismExercises._02VehiclesExtension;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;

public class Main {
    static Vehicle car;
    static Vehicle truck;
    static Vehicle bus;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 3; i++) {
            String[] info = reader.readLine().split("\\s+");

            String vehicle = info[0];
            double fuelQuantity = Double.parseDouble(info[1]);
            double fuelConsumption = Double.parseDouble(info[2]);
            double tankCapacity = Double.parseDouble(info[3]);
            switch (vehicle) {
                case "Car":
                    car = new Car(fuelQuantity, fuelConsumption, tankCapacity);
                    break;
                case "Truck":
                    truck = new Truck(fuelQuantity, fuelConsumption, tankCapacity);
                    break;
                case "Bus":
                    bus = new Bus(fuelQuantity, fuelConsumption, tankCapacity);
                    break;
            }
        }

        int n = Integer.parseInt(reader.readLine());

        for (int i = 0; i < n; i++) {
            String[] info = reader.readLine().split("\\s+");

            String vehicle = info[1];
            double amount = Double.parseDouble(info[2]);
            DecimalFormat format = new DecimalFormat("0.######");
            boolean isFull = true;

            try {
                switch (info[0]) {
                    case "DriveEmpty":
                        isFull = false;
                    case "Drive":
                        boolean driven = tryDriveVehicle(vehicle, amount, isFull);
                        String message = driven ?
                                vehicle + " travelled " + format.format(amount) + " km" :
                                vehicle + " needs refueling";
                        System.out.println(message);
                        break;
                    case "Refuel":
                        tryRefuelVehicle(vehicle, amount);
                        break;
                }

            } catch (IllegalArgumentException ex) {
                System.out.println(ex.getMessage());
            }
        }

        System.out.printf("Car: %.2f%n", car.getFuelQuantity());
        System.out.printf("Truck: %.2f%n", truck.getFuelQuantity());
        System.out.printf("Bus: %.2f%n", bus.getFuelQuantity());
    }

    private static void tryRefuelVehicle(String vehicle, double amount) {
        switch (vehicle) {
            case "Car":
                car.refuel(amount);
                break;
            case "Truck":
                truck.refuel(amount);
                break;
            case "Bus":
                bus.refuel(amount);
                break;
        }
    }

    private static boolean tryDriveVehicle(String vehicle, double amount, boolean isFull) {
        switch (vehicle) {
            case "Car":
                return car.drive(amount, 0);
            case "Truck":
                return truck.drive(amount, 0);
            case "Bus":
                double addedConsumption = (isFull) ? 1.4 : 0.0;
                return bus.drive(amount, addedConsumption);
            default:
                return false;
        }
    }
}