package models;

import loggers.Logger;
import observers.Observable;
import observers.ObservableTarget;

import java.util.ArrayList;
import java.util.List;

public class Dragon extends Entity implements ObservableTarget {
    private int health;
    private int reward;
    private Logger logger;
    private List<Observable> observers;

    public Dragon(String id, int health, int reward, Logger logger) {
        super(id);
        this.setHealth(health);
        this.setReward(reward);
        this.setLogger(logger);
        this.observers = new ArrayList<>();
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
        if(isDead()){
            this.logger.log("Target died");
        }
    }

    public int getReward() {
        if(isDead()){
            this.logger.log("Target dropped " + this.reward + " XP");
            return reward;
        }
        return 0;
    }

    public void setReward(int reward) {
        this.reward = reward;
    }


    public void setLogger(Logger logger) {
        this.logger = logger;
    }

    public boolean isDead(){
        return this.health <= 0;
    }


    @Override
    public void register(Observable observable) {
        this.observers.add(observable);
    }

    @Override
    public void unregister(Observable observable) {
        this.observers.remove(observable);
    }

    @Override
    public void notifyObservers() {
        this.observers.forEach(observable -> observable.updateXp(this.getReward()));
    }
}
