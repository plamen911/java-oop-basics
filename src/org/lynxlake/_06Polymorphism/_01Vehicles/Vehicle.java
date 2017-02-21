package org.lynxlake._06Polymorphism._01Vehicles;

abstract class Vehicle {
    private double fuelQuantity;
    private double fuelConsumption;

    protected Vehicle(double fuelQuantity, double fuelConsumption) {
        this.setFuelQuantity(fuelQuantity);
        this.setFuelConsumption(fuelConsumption);
    }

    private void setFuelQuantity(double fuelQuantity) {
        this.fuelQuantity = fuelQuantity;
    }

    private void setFuelConsumption(double fuelConsumption) {
        this.fuelConsumption = fuelConsumption;
    }

    public double getFuelQuantity() {
        return fuelQuantity;
    }

    public void refuel(double amount) {
        double currentFuel = this.getFuelQuantity();
        this.setFuelQuantity(currentFuel + amount);
    }

    public boolean drive(double distance) {
        if (distance * this.fuelConsumption <= this.fuelQuantity) {
            this.fuelQuantity -= distance * this.fuelConsumption;
            return true;
        }

        return false;
    }
}