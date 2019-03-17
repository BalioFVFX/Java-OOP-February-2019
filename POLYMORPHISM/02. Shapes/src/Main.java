import models.Circle;
import models.Rectangle;
import models.base.Shape;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Shape rectShape = new Rectangle(10d, 10d);
        Shape circleShape = new Circle(10d);

        Rectangle rectangle = new Rectangle(20d, 20d);
        Circle circle = new Circle(20d);

        List<Shape> shapes = new ArrayList<>();

        shapes.add(rectShape);
        shapes.add(circleShape);

        shapes.add(rectangle);
        shapes.add(circle);

        shapes.forEach(shape -> {
            System.out.printf("Area - %f%nPerimeter - %f%n",
                    shape.calculateArea(),
                    shape.calculatePerimeter());
        });
    }
}
