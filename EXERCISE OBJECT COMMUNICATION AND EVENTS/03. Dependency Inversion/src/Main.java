import calculator.PrimitiveCalculator;
import engine.Engine;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        PrimitiveCalculator calculator = new PrimitiveCalculator();

        new Engine(bufferedReader, calculator).run();
    }
}
