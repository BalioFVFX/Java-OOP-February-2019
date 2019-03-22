package p02_DrawingShape;

import p02_DrawingShape.interfaces.Drawable;
import p02_DrawingShape.interfaces.Shape;


public class Main {
    public static void main(String[] args) {
        Drawable circle = new Circle();
        Shape rectangle = new Rectangle();

        System.out.println(circle.draw());
        System.out.println(rectangle.draw());
    }
}
