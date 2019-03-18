package models;

import models.base.Vehicle;

public class Car extends Vehicle implements Drivable {

    public Car(double fuelQuantity, double fuelConsumption) {
        super(fuelQuantity, fuelConsumption, 0.9);
    }
}
