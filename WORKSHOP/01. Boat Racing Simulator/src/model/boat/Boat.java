package model.boat;

import exception.ArgumentException;
import model.race.Weather;

import java.util.Objects;

public abstract class Boat implements Unique{
    private String model;
    private int weight;


    public Boat(String model, int weight) throws ArgumentException {
        this.setModel(model);
        this.setWeight(weight);
    }

    @Override
    public String getModel() {
        return model;
    }

    public abstract double getSpeed(Weather weather);

    public void setModel(String model) throws ArgumentException {
        if(model.length() < 5){
            throw new ArgumentException("Model's name must be at least 5 symbols long.");
        }
        this.model = model;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) throws ArgumentException {
        if(weight <= 0){
            throw new ArgumentException("Weight must be a positive integer.");
        }
        this.weight = weight;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Boat)) return false;
        Boat boat = (Boat) o;
        return model.equals(boat.model);
    }

    @Override
    public int hashCode() {
        return Objects.hash(model);
    }

}
