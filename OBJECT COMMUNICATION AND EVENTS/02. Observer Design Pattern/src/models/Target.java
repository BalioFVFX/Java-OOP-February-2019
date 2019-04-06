package models;

import loggers.Logger;
import observers.ObservableTarget;

public interface Target {

    public int getHealth();

    public void setHealth(int health);

    public int getReward();

    public void setReward(int reward);


    public void setLogger(Logger logger);

    public boolean isDead();
}
