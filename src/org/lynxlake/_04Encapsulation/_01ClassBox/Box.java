package org.lynxlake._04Encapsulation._01ClassBox;

class Box {
    private double length;
    private double width;
    private double height;

    public Box(double length, double width, double height) {
        this.length = length;
        this.width = width;
        this.height = height;
    }

    public double getSurfaceArea() {
        return 2.0 * this.length * this.width + 2.0 * this.length * this.height + 2.0 * this.width * this.height;
    }

    public double getLateralSurfaceArea() {
        return 2.0 * this.length * this.height + 2.0 * this.width * this.height;
    }

    public double getVolume() {
        return this.length * this.width * this.height;
    }
}
