package org.lynxlake._06PolymorphismLab._03Shapes;

public class Rectangle extends Shape {
    private Double width;
    private Double height;

    public Rectangle(Double width, Double height) {
        this.width = width;
        this.height = height;
    }

    @Override
    public void calculatePerimeter() {
        this.setPerimeter(this.width * 2.0 + this.height * 2.0);
    }

    @Override
    public void calculateArea() {
        this.setArea(this.width * this.height);
    }

    public Double getWidth() {
        return width;
    }

    public Double getHeight() {
        return height;
    }
}
