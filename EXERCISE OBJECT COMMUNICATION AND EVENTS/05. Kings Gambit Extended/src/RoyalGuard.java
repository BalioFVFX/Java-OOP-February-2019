public class RoyalGuard extends Soldier implements Defensible {
    private static int HEALTH = 3;
    public RoyalGuard(String name) {
        super(name, HEALTH);
    }

    @Override
    public void defend() {
        System.out.printf("Royal Guard %s is defending!%n", super.getName());
    }
}
