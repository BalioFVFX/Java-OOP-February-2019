public class King extends Entity implements Defensible {
    public King(String name) {
        super(name);
    }

    @Override
    public void defend() {
        System.out.printf("King %s is under attack!%n", super.getName());
    }
}
