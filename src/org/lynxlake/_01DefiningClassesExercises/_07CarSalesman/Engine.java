package org.lynxlake._01DefiningClassesExercises._07CarSalesman;

class Engine implements Comparable<Engine> {
    private String model;
    private String power;
    private String displacement;
    private String efficiency;

    Engine(String model, String power, String displacement, String efficiency) {
        this.model = model;
        this.power = power;
        this.displacement = displacement;
        this.efficiency = efficiency;
    }

    public Engine(String model, String power, String efficiency) {
        this(model, power, "n/a", efficiency);
    }

    Engine(String model, String power) {
        this(model, power, "n/a", "n/a");
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getPower() {
        return this.power;
    }

    public void setPower(String power) {
        this.power = power;
    }

    public String getDisplacement() {
        return this.displacement;
    }

    public void setDisplacement(String displacement) {
        this.displacement = displacement;
    }

    public String getEfficiency() {
        return this.efficiency;
    }

    public void setEfficiency(String efficiency) {
        this.efficiency = efficiency;
    }

    @Override
    public String toString() {
        return String.format("Power: "
                + this.power + "%nDisplacement: "
                + this.displacement
                + "%nEfficiency: "
                + this.efficiency + "%n");
    }

    @Override
    public int compareTo(Engine o) {
        return 0;
    }
}


