public abstract class Soldier extends Entity {

    private int health;
    private OnSoldierKilledListener onSoldierKilledListener;

    public Soldier(String name, int health) {
        super(name);
        this.setHealth(health);
    }


    public int getHealth() {
        return health;
    }

    private void setHealth(int health) {
        this.health = health;
    }

    public void takeDamage() {
        this.health--;
        if(this.health <= 0){
            this.onSoldierKilledListener.onKilled(this);
        }
    }

    public void setonSoldierKilledListener(OnSoldierKilledListener onSoldierKilledListener){
        this.onSoldierKilledListener = onSoldierKilledListener;
    }

}
