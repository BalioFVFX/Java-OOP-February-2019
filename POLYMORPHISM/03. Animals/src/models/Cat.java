package models;

import models.base.Animal;

public class Cat extends Animal {
    public Cat(String name, String favoriteFood) {
        super(name, favoriteFood);
    }

    @Override
    public String explainSelf() {
        return String.format("I am %s and my fovourite food is %s MEEOW",
                super.getName(),
                super.getFavoriteFood());
    }
}
