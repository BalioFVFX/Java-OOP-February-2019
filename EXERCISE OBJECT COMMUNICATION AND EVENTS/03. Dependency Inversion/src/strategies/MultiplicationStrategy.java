package strategies;

import strategies.base.Strategy;

public class MultiplicationStrategy implements Strategy {
    @Override
    public int calculate(int first, int second) {
        return first * second;
    }
}
