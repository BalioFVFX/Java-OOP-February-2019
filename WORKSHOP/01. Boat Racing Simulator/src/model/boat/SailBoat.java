package model.boat;

import exception.ArgumentException;
import model.race.Weather;

public class SailBoat extends Boat {
    private int sailEfficiency;

    public SailBoat(String model, int weight, int sailEfficiency) throws ArgumentException {
        super(model, weight);
        this.setSailEfficiency(sailEfficiency);
    }

    public int getSailEfficiency() {
        return sailEfficiency;
    }

    public void setSailEfficiency(int sailEfficiency) throws ArgumentException {
        if(sailEfficiency < 1 || sailEfficiency > 100){
            throw new ArgumentException("Sail Effectiveness must be between [1...100].");
        }
        this.sailEfficiency = sailEfficiency;
    }


    @Override
    public double getSpeed(Weather weather) {
        return (weather.getWindSpeed() * (this.sailEfficiency / 100.0)) - this.getWeight() + (weather.getOceanCurrentSpeed() / 2.0);
    }
}
