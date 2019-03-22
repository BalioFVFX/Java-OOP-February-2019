import interfaces.Renderer;
import interfaces.Shape;

public class Main {
    public static void main(String[] args) {
        Shape rectangle = new Rectangle(10, 20);
        Renderer renderer = new RendererImpl();

        renderer.render(rectangle);
    }
}
