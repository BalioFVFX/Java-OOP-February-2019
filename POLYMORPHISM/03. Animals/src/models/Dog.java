package models;

import models.base.Animal;

public class Dog extends Animal {
    public Dog(String name, String favoriteFood) {
        super(name, favoriteFood);
    }

    @Override
    public String explainSelf() {
        return String.format("I am %s and my fovourite food is %s DJAAF",
                super.getName(),
                super.getFavoriteFood());
    }
}
