package money;

public class Money {
    long price;

    public Money(long price) {
        this.price = price;
    }

    public long getPrice() {
        return this.price;
    }

    public void incrementPriceBy(Long price) {
        this.price += price;
    }
}
