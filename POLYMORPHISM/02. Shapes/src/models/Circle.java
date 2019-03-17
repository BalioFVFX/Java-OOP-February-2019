package models;

import models.base.Shape;

public class Circle extends Shape {

    private Double radius;

    public Circle(Double radius) {
        this.setRadius(radius);
    }

    @Override
    public Double calculatePerimeter() {
        super.setPerimeter(Math.PI * 2 * this.radius);
        return super.getArea();
    }

    @Override
    public Double calculateArea() {
        super.setArea(Math.PI * radius * radius);
        return super.getArea();
    }

    public final Double getRadius() {
        return radius;
    }

    public void setRadius(Double radius) {
        this.radius = radius;
    }
}
