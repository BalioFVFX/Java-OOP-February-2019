package commands;

import strategies.AddStrategy;
import strategies.DivideStrategy;
import strategies.MultiplicationStrategy;
import strategies.SubtractStrategy;
import strategies.base.Strategy;

public class StrategyCreator {
    public static Strategy createFrom(String input) {
        String operator = input.split("\\s+")[1];

        switch (operator) {
            case "+":
                return new AddStrategy();
            case "-":
                return new SubtractStrategy();
            case "*":
                return new MultiplicationStrategy();
            case "/":
                return new DivideStrategy();
            default:
                return null;
        }
    }
}
