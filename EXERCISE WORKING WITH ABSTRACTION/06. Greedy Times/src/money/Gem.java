package money;

public class Gem extends Money {
    private String name;

    public Gem(String name, long price) {
        super(price);
        this.name = name;
    }

    @Override
    public String toString() {
        return String.format("##%s - %s", this.name, this.price);
    }

    public String getName() {
        return name;
    }

}
