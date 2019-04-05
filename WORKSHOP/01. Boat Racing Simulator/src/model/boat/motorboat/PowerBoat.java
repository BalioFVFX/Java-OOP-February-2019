package model.boat.motorboat;

import exception.ArgumentException;
import model.boat.Boat;
import model.engine.Engine;
import model.race.Weather;

public class PowerBoat extends Motorboat {
    private Engine secondEngine;

    public PowerBoat(String model, int weight, Engine firstEngine, Engine secondEngine) throws ArgumentException {
        super(model, weight, firstEngine);
        this.setSecondEngine(secondEngine);
    }


    public Engine getFirstEngine() {
        return super.getEngine();
    }

    public void setFirstEngine(Engine firstEngine) {
        super.setEngine(firstEngine);
    }

    public Engine getSecondEngine() {
        return secondEngine;
    }

    public void setSecondEngine(Engine secondEngine) {
        this.secondEngine = secondEngine;
    }

    @Override
    public double getSpeed(Weather weather) {
        return (getFirstEngine().getOutput() + getSecondEngine().getOutput()) - this.getWeight() + (weather.getOceanCurrentSpeed() / 5.0);
    }
}
