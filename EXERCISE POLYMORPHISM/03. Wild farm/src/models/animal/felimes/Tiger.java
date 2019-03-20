package models.animal.felimes;

import models.animal.base.Felime;
import models.food.Meat;
import models.food.base.Food;

public class Tiger extends Felime {
    public Tiger(String animalName, String animalType, Double animalWeight, String livingRegion) {
        super(animalName, animalType, animalWeight, livingRegion);
    }

    @Override
    public void makeSound() {
        System.out.println("ROAAR!!!");
    }

    @Override
    public void eat(Food food) {
        if(food instanceof Meat){
            this.setFoodEatean(this.getFoodEatean() + food.getQuantity());
        }
        else{
            System.out.println(this.getAnimalType() + "s are not eating that type of food!");
        }
    }
}
