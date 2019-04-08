public class RoyalGuard extends Entity implements Defensible {
    public RoyalGuard(String name) {
        super(name);
    }

    @Override
    public void defend() {
        System.out.printf("Royal Guard %s is defending!%n", super.getName());
    }
}
