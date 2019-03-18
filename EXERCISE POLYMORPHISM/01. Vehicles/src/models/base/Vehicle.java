package models.base;

import models.Drivable;

import java.text.DecimalFormat;

public abstract class Vehicle implements Drivable {
    private double fuelQuantity;
    private double fuelConsumption;
    private final double AC_FUEL_CONSUMPTION_INCREASE_VALUE;

    public Vehicle(double fuelQuantity, double fuelConsumption, double AC_FUEL_CONSUMPTION_INCREASE_VALUE) {
        this.setFuelQuantity(fuelQuantity);
        this.setFuelConsumption(fuelConsumption);
        this.AC_FUEL_CONSUMPTION_INCREASE_VALUE = AC_FUEL_CONSUMPTION_INCREASE_VALUE;
    }

    public double getFuelQuantity() {
        return fuelQuantity;
    }

    public void setFuelQuantity(double fuelQuantity) {
        this.fuelQuantity = fuelQuantity;
    }

    public double getFuelConsumption() {
        return fuelConsumption;
    }

    public void setFuelConsumption(double fuelConsumption) {
        this.fuelConsumption = fuelConsumption;
    }


    @Override
    public String drive(double distance) {
        double totalFuelConsumption = this.getFuelConsumption() + AC_FUEL_CONSUMPTION_INCREASE_VALUE;

        if (totalFuelConsumption * distance > this.getFuelQuantity()) {
            return this.getClass().getSimpleName() + " needs refueling";
        }

        this.setFuelQuantity(this.getFuelQuantity() - totalFuelConsumption * distance);
        DecimalFormat decimalFormat = new DecimalFormat("#.##");
        return String.format("%s travelled %s km", this.getClass().getSimpleName(), decimalFormat.format(distance));
    }

    @Override
    public void refill(double liters) {
        this.setFuelQuantity(this.getFuelQuantity() + liters);
    }

    @Override
    public String toString() {
        return String.format("%s: %.2f",
                this.getClass().getSimpleName(),
                this.getFuelQuantity());
    }
}
