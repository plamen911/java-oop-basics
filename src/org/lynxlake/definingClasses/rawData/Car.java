package org.lynxlake.definingClasses.rawData;

class Car {
    private String model;
    private Engine engine;
    private Cargo cargo;
    private Tire[] tires = new Tire[4];

    public Car(String model, Engine engine, Cargo cargo, Tire[] tires) {
        this.model = model;
        this.engine = engine;
        this.cargo = cargo;
        this.tires = tires;
    }

    public Engine getEngine() {
        return engine;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    public Cargo getCargo() {
        return cargo;
    }

    public void setCargo(Cargo cargo) {
        this.cargo = cargo;
    }

    public Tire[] getTires() {
        return tires;
    }

    public void setTires(Tire[] tires) {
        this.tires = tires;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }
}


