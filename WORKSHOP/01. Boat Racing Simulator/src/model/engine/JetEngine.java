package model.engine;

import exception.ArgumentException;

public class JetEngine extends Engine {

    public JetEngine(String model, int horsePower, int displacement) throws ArgumentException {
        super(model, horsePower, displacement);
    }

    @Override
    public int getOutput() {
        return (this.getHorsePower() * 5) + this.getDisplacement();
    }
}
