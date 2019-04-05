package model.engine;

import exception.ArgumentException;

public class SterndriveEngine extends Engine {

    public SterndriveEngine(String model, int horsePower, int displacement) throws ArgumentException {
        super(model, horsePower, displacement);
    }

    @Override
    public int getOutput() {
        return (this.getHorsePower() * 7) + this.getDisplacement();
    }
}
