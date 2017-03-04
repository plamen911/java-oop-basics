package org.lynxlake._06PolymorphismExercises._01Vehicles;

class Car extends Vehicle {
    private final static double addedConsumption = 0.9;

    public Car(double fuelQuantity, double fuelConsumption) {
        super(fuelQuantity, fuelConsumption + addedConsumption);
    }
}
