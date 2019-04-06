package models;

import loggers.Logger;


public interface Attacker {
    void setLogger(Logger logger);

    void setTarget(Target target);

    int getDamage();

    void setDamage(int damage);

    void attack();

    int getXp();
}
