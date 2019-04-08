package strategies;

import strategies.base.Strategy;

public class AddStrategy implements Strategy {
    @Override
    public int calculate(int first, int second) {
        return first + second;
    }
}
