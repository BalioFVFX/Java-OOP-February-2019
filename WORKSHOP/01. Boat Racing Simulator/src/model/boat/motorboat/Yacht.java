package model.boat.motorboat;

import exception.ArgumentException;
import model.engine.Engine;
import model.race.Weather;

public class Yacht extends Motorboat {

    private int cargoWeight;

    public Yacht(String model, int weight, Engine engine, int cargoWeight) throws ArgumentException {
        super(model, weight, engine);
        this.setCargoWeight(cargoWeight);
    }


    public int getCargoWeight() {
        return cargoWeight;
    }

    public void setCargoWeight(int cargoWeight) throws ArgumentException {
        if(cargoWeight <= 0){
            throw new ArgumentException("Cargo Weight must be a positive integer.");
        }
        this.cargoWeight = cargoWeight;
    }

    @Override
    public double getSpeed(Weather weather) {
        return getEngine().getOutput() - (this.getWeight() + this.cargoWeight) + (weather.getOceanCurrentSpeed() / 2.0);
    }
}
