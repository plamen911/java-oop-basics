package org.lynxlake._06PolymorphismExercises._02VehiclesExtensionV2;

class Car extends Vehicle {
    private final static double addedConsumption = 0.9;

    public Car(double fuelQuantity, double fuelConsumption, double tankCapacity) throws Exception {
        super(fuelQuantity, fuelConsumption + addedConsumption, tankCapacity);
    }

    @Override
    protected void setFuelQuantity(double fuelQuantity) throws Exception {
        if (fuelQuantity > super.getTankCapacity()) {
            throw new Exception("Cannot fit fuel in tank");
        }
        super.setFuelQuantity(fuelQuantity);
    }
}
