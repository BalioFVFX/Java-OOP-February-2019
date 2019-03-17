package models;

import models.base.Shape;

public class Rectangle extends Shape {
    private Double width;
    private Double height;

    public Rectangle(Double width, Double height) {
        this.setWidth(width);
        this.setHeight(height);
    }

    @Override
    public Double calculatePerimeter() {
        super.setPerimeter(2 * this.width * this.height);
        return super.getPerimeter();
    }

    @Override
    public Double calculateArea() {
        super.setArea(this.width * this.height);
        return super.getArea();
    }

    public Double getWidth() {
        return width;
    }

    public void setWidth(Double width) {
        this.width = width;
    }

    public Double getHeight() {
        return height;
    }

    public void setHeight(Double height) {
        this.height = height;
    }
}
