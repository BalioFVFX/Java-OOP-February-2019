package models;

import models.base.Vehicle;

public class Car extends Vehicle implements Drivable {

    public Car(double fuelQuantity, double fuelConsumption, double tankCapacity) {
        super(fuelQuantity, fuelConsumption, tankCapacity, 0.9);
    }
}