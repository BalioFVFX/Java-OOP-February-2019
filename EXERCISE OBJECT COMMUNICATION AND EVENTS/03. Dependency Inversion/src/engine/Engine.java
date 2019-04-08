package engine;

import calculator.PrimitiveCalculator;
import commands.OperandsCreator;
import commands.StrategyCreator;
import strategies.base.Strategy;

import java.io.BufferedReader;
import java.io.IOException;


public class Engine {
    private BufferedReader bufferedReader;
    private PrimitiveCalculator calculator;

    public Engine(BufferedReader bufferedReader, PrimitiveCalculator calculator) {
        this.bufferedReader = bufferedReader;
        this.calculator = calculator;
    }

    public void run() throws IOException {
        String input = bufferedReader.readLine();
        while (!input.equals("End")) {
            if (input.contains("mode")) {
                Strategy strategy = StrategyCreator.createFrom(input);
                this.calculator.changeStrategy(strategy);
            } else {
                int[] operands = OperandsCreator.createFrom(input);
                int result = this.calculator.performCalculation(operands[0], operands[1]);

                System.out.println(result);
            }
            input = bufferedReader.readLine();
        }

    }


}
