import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.List;

public class Person {
    private String name;
    private double money;
    private List<Product> products;

    public Person() {
        this.products = new ArrayList<>();
    }

    public Person(String name, double money) {
        this();
        this.setName(name);
        this.setMoney(money);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        Validator.validateName(name);
        this.name = name;
    }


    public void setMoney(double money) {
        Validator.validateMoney(money);
        this.money = money;
    }

    public void buyProduct(Product product) {
        try {
            this.setMoney(this.money - product.getCost());
            System.out.printf("%s bought %s%n", this.name, product.toString());
            products.add(product);
        } catch (InvalidParameterException ex) {
            throw new InvalidParameterException(String.format("%s can't afford %s", this.name, product.getName()));
        }
    }

    @Override
    public String toString() {
        if (this.products.isEmpty()) {
            return String.format("%s - Nothing bought", this.name);
        }

        return this.name + " - " + String.join(", ", this.products);

    }
}
