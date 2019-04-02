package rpg_lab;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Hero {

    private String name;
    private int experience;
    private Weapon weapon;
    private List<Weapon> weapons;

    public Hero(Weapon weapon, String name) {
        this.name = name;
        this.experience = 0;
        this.weapon = weapon;
        this.weapons = new ArrayList<Weapon>();
    }

    public String getName() {
        return this.name;
    }

    public int getExperience() {
        return this.experience;
    }

    public Weapon getWeapon() {
        return this.weapon;
    }

    public void attack(Target target) {
        this.weapon.attack(target);

        if (target.isDead()) {
            this.experience += target.giveExperience();
            this.weapons.add(target.giveLoot());
        }
    }

    public Iterable<Weapon> getInventory(){
        return this.weapons;
    }
}
