import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        Integer circleRadius = Integer.parseInt(bufferedReader.readLine());

        Integer rectangleWidth = Integer.parseInt(bufferedReader.readLine());
        Integer rectangleHeight = Integer.parseInt(bufferedReader.readLine());

        Drawable circle = new Circle(circleRadius);
        Drawable rect = new Rectangle(rectangleWidth, rectangleHeight);

        circle.draw();
        rect.draw();
    }
}
