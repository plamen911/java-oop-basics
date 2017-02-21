package org.lynxlake._06Polymorphism._02VehiclesExtension;

class Truck extends Vehicle {
    private static final double addedConsumption = 1.6;

    public Truck(double fuelQuantity, double fuelConsumption, double tankCapacity) {
        super(fuelQuantity, fuelConsumption + addedConsumption, tankCapacity);
    }

    @Override
    public void refuel(double amount) {
        super.refuel(amount * 0.95);
    }
}
