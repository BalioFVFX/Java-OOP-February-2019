package rpg_lab;

public interface Target {
    public void takeAttack(int attackPoints);
    int getHealth();
    int giveExperience();
    boolean isDead();
    Weapon giveLoot();
}
