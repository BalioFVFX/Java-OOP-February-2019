public class Footman extends Entity implements Defensible {
    public Footman(String name) {
        super(name);
    }

    @Override
    public void defend() {
        System.out.printf("Footman %s is panicking!%n", super.getName());
    }
}
