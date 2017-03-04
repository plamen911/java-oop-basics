package org.lynxlake._06PolymorphismExercises._02VehiclesExtension;

class Car extends Vehicle {
    private final static double addedConsumption = 0.9;

    public Car(double fuelQuantity, double fuelConsumption, double tankCapacity) {
        super(fuelQuantity, fuelConsumption + addedConsumption, tankCapacity);
    }
}
