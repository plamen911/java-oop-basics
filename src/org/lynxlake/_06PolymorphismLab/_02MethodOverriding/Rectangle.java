package org.lynxlake._06PolymorphismLab._02MethodOverriding;

public class Rectangle {
    private double sideA;
    private double sideB;

    public Rectangle(double sideA) {
        this.sideA = sideA;
        this.sideB = sideA;
    }

    public Rectangle(double sideA, double sideB) {
        this.sideA = sideA;
        this.sideB = sideB;
    }

    public double area() {
        return this.sideA * this.sideB;
    }

    public double getSideA() {
        return sideA;
    }

    public double getSideB() {
        return sideB;
    }
}
