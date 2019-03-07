public class Product implements CharSequence {
    private String name;
    private double cost;

    public Product(String name, double cost) {
        this.setName(name);
        this.setCost(cost);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        Validator.validateName(name);
        this.name = name;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        Validator.validateMoney(cost);
        this.cost = cost;
    }

    @Override
    public int length() {
        return this.name.length();
    }

    @Override
    public char charAt(int index) {
        return this.name.charAt(index);
    }

    @Override
    public CharSequence subSequence(int start, int end) {
        return this.name.substring(start, end);
    }

    @Override
    public String toString() {
        return this.name;
    }
}
