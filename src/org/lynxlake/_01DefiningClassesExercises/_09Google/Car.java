package org.lynxlake._01DefiningClassesExercises._09Google;

class Car {
    private String carModel;
    private String carSpeed;

    public Car(String carModel, String carSpeed) {
        this.carModel = carModel;
        this.carSpeed = carSpeed;
    }

    public String getCarModel() {
        return carModel;
    }

    public String getCarSpeed() {
        return carSpeed;
    }
}
