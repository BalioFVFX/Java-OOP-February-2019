import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        Light[] lights = Arrays.stream(bufferedReader.readLine().split("\\s+")).map(s -> new Light(Signal.valueOf(s))).toArray(Light[]::new);

        int numberOfLightChanges = Integer.parseInt(bufferedReader.readLine());

        for (int i = 0; i < numberOfLightChanges; i++) {
            for (int j = 0; j < lights.length; j++) {
                lights[j].changeSignal();
                System.out.print(lights[j] + " ");
            }
            System.out.println();
        }
    }
}
