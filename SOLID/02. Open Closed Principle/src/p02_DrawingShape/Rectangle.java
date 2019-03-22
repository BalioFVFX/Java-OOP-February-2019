package p02_DrawingShape;

import p02_DrawingShape.interfaces.Shape;

public class Rectangle implements Shape {

    @Override
    public String draw() {
        return "Drawing a rectangle";
    }
}
