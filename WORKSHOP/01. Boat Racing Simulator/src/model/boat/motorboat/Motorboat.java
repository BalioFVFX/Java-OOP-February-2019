package model.boat.motorboat;

import exception.ArgumentException;
import model.boat.Boat;
import model.engine.Engine;

public abstract class Motorboat extends Boat {

    private Engine engine;

    public Motorboat(String model, int weight, Engine engine) throws ArgumentException {
        super(model, weight);
        this.setEngine(engine);
    }

    public Engine getEngine() {
        return engine;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }
}
