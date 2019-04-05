package model.boat;

import exception.ArgumentException;
import model.race.Weather;

public class RowBoat extends Boat {
    private int oars;

    public RowBoat(String model, int weight, int oars) throws ArgumentException {
        super(model, weight);
        this.setOars(oars);
    }

    public int getOars() {
        return oars;
    }

    public void setOars(int oars) throws ArgumentException {
        if(oars <= 0){
            throw new ArgumentException("Oars must be a positive integer.");
        }
        this.oars = oars;
    }


    @Override
    public double getSpeed(Weather weather) {
        return (this.oars * 100) - this.getWeight() + weather.getOceanCurrentSpeed();
    }
}
