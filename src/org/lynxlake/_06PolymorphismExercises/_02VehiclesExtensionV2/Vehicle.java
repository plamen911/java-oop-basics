package org.lynxlake._06PolymorphismExercises._02VehiclesExtensionV2;

abstract class Vehicle {
    private double fuelQuantity;
    private double fuelConsumption;
    private double tankCapacity;

    protected Vehicle(double fuelQuantity, double fuelConsumption, double tankCapacity) throws Exception {
        this.setTankCapacity(tankCapacity);
        this.setFuelQuantity(fuelQuantity);
        this.setFuelConsumption(fuelConsumption);
    }

    protected double getTankCapacity() {
        return this.tankCapacity;
    }

    protected void setFuelQuantity(double fuelQuantity) throws Exception {
        if (fuelQuantity < 0) {
            throw new Exception("Fuel must be a positive number.");
        }
        this.fuelQuantity = fuelQuantity;
    }

    private void setTankCapacity(double tankCapacity) {
        this.tankCapacity = tankCapacity;
    }

    protected void setFuelConsumption(double fuelConsumption) {
        this.fuelConsumption = fuelConsumption;
    }

    public double getFuelQuantity() {
        return fuelQuantity;
    }

    public void refuel(double amount) throws Exception {
        double currentFuel = this.getFuelQuantity();
        this.setFuelQuantity(currentFuel + amount);
    }

    public boolean drive(double distance) throws Exception {
        if (distance * this.fuelConsumption <= this.fuelQuantity) {
            double fuelQuantity = this.getFuelQuantity();
            fuelQuantity -= distance * this.fuelConsumption;
            this.setFuelQuantity(fuelQuantity);
            return true;
        }

        return false;
    }
}
