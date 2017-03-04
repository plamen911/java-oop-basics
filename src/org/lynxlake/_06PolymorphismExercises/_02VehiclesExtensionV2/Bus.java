package org.lynxlake._06PolymorphismExercises._02VehiclesExtensionV2;

class Bus extends Vehicle {
    private double fuelConsumption;
    private final static double addedConsumption = 1.4;

    protected Bus(double fuelQuantity, double fuelConsumption, double tankCapacity) throws Exception {
        super(fuelQuantity, fuelConsumption, tankCapacity);
        this.fuelConsumption = fuelConsumption;
    }

    public void setFuelConsumptionWithPeople() {
        super.setFuelConsumption(this.fuelConsumption + addedConsumption);
    }

    public void setFuelConsumptionEmpty() {
        super.setFuelConsumption(this.fuelConsumption);
    }

    @Override
    protected void setFuelQuantity(double fuelQuantity) throws Exception {
        if (fuelQuantity > this.getTankCapacity()) {
            throw new Exception("Cannot fit fuel in tank");
        }
        super.setFuelQuantity(fuelQuantity);
    }
}
