package models.base;

public abstract class Animal {
    private String name;
    private String favoriteFood;

    public Animal(String name, String favoriteFood) {
        this.setName(name);
        this.setFavoriteFood(favoriteFood);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFavoriteFood() {
        return favoriteFood;
    }

    public void setFavoriteFood(String favoriteFood) {
        this.favoriteFood = favoriteFood;
    }

    public abstract String explainSelf();
}
