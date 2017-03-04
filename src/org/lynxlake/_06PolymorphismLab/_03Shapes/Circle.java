package org.lynxlake._06PolymorphismLab._03Shapes;

public class Circle extends Shape {
    private Double radius;

    public Circle(Double radius) {
        this.radius = radius;
    }

    @Override
    public void calculatePerimeter() {
        this.setPerimeter(2.0 * Math.PI * this.radius);
    }

    @Override
    public void calculateArea() {
        this.setArea(Math.PI * this.radius * this.radius);
    }

    public final Double getRadius() {
        return this.getPerimeter();
    }
}
