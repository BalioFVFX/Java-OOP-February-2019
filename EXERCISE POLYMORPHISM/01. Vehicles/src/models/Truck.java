package models;

import models.base.Vehicle;

public class Truck extends Vehicle implements Drivable {

    public Truck(double fuelQuantity, double fuelConsumption) {
        super(fuelQuantity, fuelConsumption, 1.6);
    }

    @Override
    public void refill(double liters) {
        this.setFuelQuantity(super.getFuelQuantity() + liters * 0.95);
    }
}
