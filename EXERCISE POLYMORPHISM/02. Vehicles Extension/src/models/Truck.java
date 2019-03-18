package models;

import models.base.Vehicle;

public class Truck extends Vehicle implements Drivable {

    public Truck(double fuelQuantity, double fuelConsumption, double tankCapacity) {
        super(fuelQuantity, fuelConsumption, tankCapacity, 1.6);
    }

    @Override
    public void refill(double liters) {
        if(liters <= 0){
            throw new IllegalArgumentException("Fuel must be a positive number");
        }
        this.setFuelQuantity(super.getFuelQuantity() + liters * 0.95);
    }
}