public class Footman extends Soldier implements Defensible {

    private static final int HEALTH = 2;

    public Footman(String name) {
        super(name, HEALTH);
    }



    @Override
    public void defend() {
        System.out.printf("Footman %s is panicking!%n", super.getName());
    }

}
