package calculator;

import strategies.AddStrategy;
import strategies.base.Strategy;

public class PrimitiveCalculator {
    private Strategy strategy;

    public PrimitiveCalculator() {
        this.strategy = new AddStrategy();
    }

    public void changeStrategy(Strategy strategy){
        this.strategy = strategy;
    }

    public int performCalculation(int first, int second){
        return this.strategy.calculate(first, second);
    }
}
