package org.lynxlake._06PolymorphismExercises._02VehiclesExtension;

abstract class Vehicle {
    protected double fuelQuantity;
    protected double fuelConsumption;
    protected double tankCapacity;

    protected Vehicle(double fuelQuantity, double fuelConsumption, double tankCapacity) {
        this.setFuelQuantity(fuelQuantity);
        this.setFuelConsumption(fuelConsumption);
        this.setTankCapacity(tankCapacity);
    }

    public double getFuelQuantity() {
        return this.fuelQuantity;
    }

    public void refuel(double amount) {
        double currentFuel = this.getFuelQuantity();
        if ((currentFuel + amount) > this.tankCapacity) {
            throw new IllegalArgumentException("Cannot fit fuel in tank");
        }
        this.setFuelQuantity(currentFuel + amount);
    }

    public boolean drive(double distance, double addedConsumption) {
        double fuelConsumption = this.fuelConsumption + addedConsumption;
        if (distance * fuelConsumption <= this.fuelQuantity) {
            this.fuelQuantity -= distance * fuelConsumption;
            return true;
        }

        return false;
    }

    private void setFuelQuantity(double fuelQuantity) {
        this.fuelQuantity = fuelQuantity;
    }

    private void setFuelConsumption(double fuelConsumption) {
        if (fuelConsumption < 0) {
            throw new IllegalArgumentException("Fuel must be a positive number");
        }
        this.fuelConsumption = fuelConsumption;
    }

    private void setTankCapacity(double tankCapacity) {
        this.tankCapacity = tankCapacity;
    }
}