import interfaces.Drawable;
import interfaces.Renderer;

public class RendererImpl implements Renderer {
    @Override
    public void render(Drawable drawable) {
        System.out.println(drawable.draw());
    }
}
