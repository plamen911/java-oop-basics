package org.lynxlake._06PolymorphismExercises._02VehiclesExtensionV2;

class Truck extends Vehicle {
    private static final double addedConsumption = 1.6;

    public Truck(double fuelQuantity, double fuelConsumption, double tankCapacity) throws Exception {
        super(fuelQuantity, fuelConsumption + addedConsumption, tankCapacity);
    }

    @Override
    public void refuel(double amount) throws Exception {
        super.refuel(amount * 0.95);
    }
}
