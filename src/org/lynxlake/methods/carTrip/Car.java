package org.lynxlake.methods.carTrip;

class Car {
    private double speed;
    private double fuel;
    private double fuelEconomy;
    private double fuelAmount;
    private double distance;
    private double time;

    public Car(double speed, double fuelAmount, double fuelEconomy) {
        this.speed = speed;
        this.fuelEconomy = fuelEconomy;
        this.fuelAmount = fuelAmount;
        this.distance = 0;
        this.time = 0;
    }

    public double getFuel() {
        return fuel;
    }

    public double getTime() {
        return time;
    }

    public double getDistance() {
        return distance;
    }

    public double getFuelAmount() {
        return fuelAmount;
    }

    public void refuel(double litters) {
        if (litters < 0) {
            return;
        }
        this.fuelAmount += litters;
    }

    public void travel(double distance) {
        double canTravel = (this.fuelAmount * 100) / this.fuelEconomy;
        if (canTravel < distance) {
            distance = canTravel;
        }
        this.fuelAmount -= distance * (this.fuelEconomy / 100);
        this.distance += distance;
        this.time += (distance / this.speed) * 60;
    }
}
