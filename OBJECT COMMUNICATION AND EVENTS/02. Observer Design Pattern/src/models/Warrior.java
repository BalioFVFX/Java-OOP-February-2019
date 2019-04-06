package models;

import loggers.Logger;
import observers.Observable;

public class Warrior extends Entity implements Attacker, Observable {

    private Target target;
    private int damage;
    private Logger logger;
    private int xp;

    public Warrior(String id, int damage, Logger logger) {
        super(id);
        this.setDamage(damage);
        this.setLogger(logger);
        this.xp = 0;

    }

    @Override
    public void setLogger(Logger logger) {
        this.logger = logger;
    }

    @Override
    public void setTarget(Target target) {
        this.target = target;
    }

    @Override
    public int getDamage() {
        return this.damage;
    }

    @Override
    public void setDamage(int damage) {
        this.damage = damage;
    }

    @Override
    public void attack() {
        if(this.target == null){
            throw new IllegalArgumentException("Target not set");
        }

        this.logger.log("Attacker attacked the target!");
        this.target.setHealth(this.target.getHealth()  - this.getDamage());
        if(this.target.isDead()){
            int droppedXp = this.target.getReward();
            this.xp += droppedXp;
            this.logger.log("Attacker took " + droppedXp + " xp");
        }

    }

    @Override
    public int getXp() {
        return this.xp;
    }

    @Override
    public void updateXp(int xp) {
        this.xp += xp;
        this.logger.log("Attacker received " + xp + " xp through observer and now has " + this.xp + " total xp");
    }
}
