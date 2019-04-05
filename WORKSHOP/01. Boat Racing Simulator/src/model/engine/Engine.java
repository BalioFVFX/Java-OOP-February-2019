package model.engine;

import exception.ArgumentException;
import model.boat.Unique;

public abstract class Engine implements Unique {
    private String model;
    private int horsePower;
    private int displacement;

    public Engine(String model, int horsePower, int displacement) throws ArgumentException {
        this.setModel(model);
        this.setHorsePower(horsePower);
        this.setDisplacement(displacement);
    }


    public abstract int getOutput();

    @Override
    public String getModel() {
        return model;
    }

    public void setModel(String model) throws ArgumentException {
        if(model.length() < 3){
            throw new ArgumentException("Model's name must be at least 3 symbols long.");
        }
        this.model = model;
    }

    public int getHorsePower() {
        return horsePower;
    }

    public void setHorsePower(int horsePower) throws ArgumentException {
        if(horsePower <= 0){
            throw new ArgumentException("Horsepower must be a positive integer.");
        }
        this.horsePower = horsePower;
    }

    public int getDisplacement() {
        return displacement;
    }

    public void setDisplacement(int displacement) throws ArgumentException {
        if(displacement <= 0){
            throw new ArgumentException("Displacement must be a positive integer.");
        }
        this.displacement = displacement;
    }
}
