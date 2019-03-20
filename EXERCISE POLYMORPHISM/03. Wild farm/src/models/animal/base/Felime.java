package models.animal.base;

import models.food.base.Food;

public abstract class Felime extends Mammal {
    public Felime(String animalName, String animalType, Double animalWeight, String livingRegion) {
        super(animalName, animalType, animalWeight, livingRegion);
    }

    @Override
    public void eat(Food food) {
        this.setFoodEatean(this.getFoodEatean() + food.getQuantity());
    }
}
