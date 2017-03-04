package org.lynxlake._06PolymorphismLab._03Shapes;

public abstract class Shape {
    private Double perimeter;
    private Double area;

    public Shape() {

    }

    public abstract void calculatePerimeter();

    public abstract void calculateArea();

    public Double getPerimeter() {
        return this.perimeter;
    }

    public Double getArea() {
        return this.area;
    }

    protected void setPerimeter(Double perimeter) {
        this.perimeter = perimeter;
    }

    protected void setArea(Double area) {
        this.area = area;
    }
}
