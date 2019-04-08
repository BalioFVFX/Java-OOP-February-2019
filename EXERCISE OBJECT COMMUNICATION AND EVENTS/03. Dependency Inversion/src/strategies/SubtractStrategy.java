package strategies;

import strategies.base.Strategy;

public class SubtractStrategy implements Strategy {
    @Override
    public int calculate(int first, int second) {
        return first - second;
    }
}
