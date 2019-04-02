package rpg_lab;

public interface Weapon {
    public void attack(Target target);
    int getAttackPoints();
    int getDurabilityPoints();
}
