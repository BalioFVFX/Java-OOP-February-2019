import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int[] rectArgs = getArgs(bufferedReader);

        Rectangle rectangle = Rectangle.create(rectArgs);

        int numberOfPoints = Integer.parseInt(bufferedReader.readLine());

        for (int i = 0; i < numberOfPoints; i++) {
            int[] pointArgs = getArgs(bufferedReader);
            Point point = new Point(pointArgs[0], pointArgs[1]);
            System.out.println(rectangle.contains(point));
        }
    }

    private static int[] getArgs(BufferedReader bufferedReader) throws IOException {
        return Arrays.stream(bufferedReader.readLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
    }
}
