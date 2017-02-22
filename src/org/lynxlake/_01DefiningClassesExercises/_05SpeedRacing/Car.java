package org.lynxlake._01DefiningClassesExercises._05SpeedRacing;

class Car {
    private String carModel;
    private double fuelAmount;
    private double fuelCostForKm;
    private double distanceTravelled;

    Car(String carModel, double fuelAmount, double fuelCostForKm) {
        this.carModel = carModel;
        this.fuelAmount = fuelAmount;
        this.fuelCostForKm = fuelCostForKm;
        this.distanceTravelled = 0.0;
    }

    public String getCarModel() {
        return carModel;
    }

    public void setCarModel(String carModel) {
        this.carModel = carModel;
    }

    public double getFuelAmount() {
        return fuelAmount;
    }

    public void setFuelAmount(double fuelAmount) {
        this.fuelAmount = fuelAmount;
    }

    public double getFuelCostForKm() {
        return fuelCostForKm;
    }

    public void setFuelCostForKm(double fuelCostForKm) {
        this.fuelCostForKm = fuelCostForKm;
    }

    public double getDistanceTravelled() {
        return distanceTravelled;
    }

    public void setDistanceTravelled(double distanceTravelled) {
        this.distanceTravelled = distanceTravelled;
    }

    void drive(double amountOfKm) {
        double fuelAmount = this.fuelAmount;
        fuelAmount -= amountOfKm * this.fuelCostForKm;
        if (fuelAmount >= 0) {
            this.fuelAmount = fuelAmount;
            this.distanceTravelled += amountOfKm;
        } else {
            System.out.println("Insufficient fuel for the drive");
        }
    }

    void driveReport() {
        System.out.printf("%s %.2f %d %n", this.carModel, this.fuelAmount, (int)this.distanceTravelled);
    }
}
