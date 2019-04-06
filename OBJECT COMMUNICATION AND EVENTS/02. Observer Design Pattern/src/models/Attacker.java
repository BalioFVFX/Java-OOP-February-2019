package models;

import loggers.Logger;
import observers.Observable;


public interface Attacker extends Observable {
    void setLogger(Logger logger);

    void setTarget(Target target);

    int getDamage();

    void setDamage(int damage);

    void attack();

    int getXp();
}
