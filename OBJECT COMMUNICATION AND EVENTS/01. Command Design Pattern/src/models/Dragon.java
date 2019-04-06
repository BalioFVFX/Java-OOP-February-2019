package models;

import loggers.Logger;

public class Dragon extends Entity implements Target{
    private int health;
    private int reward;
    private Logger logger;

    public Dragon(String id, int health, int reward, Logger logger) {
        super(id);
        this.setHealth(health);
        this.setReward(reward);
        this.setLogger(logger);
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
}
