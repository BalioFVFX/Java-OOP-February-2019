

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class Instock implements ProductStock {

    private List<Product> products;

    public Instock() {
        this.products = new ArrayList<Product>();
    }

    public int getCount() {
        return this.products.size();
    }


    public boolean contains(Product product) {
        return this.products.contains(product);
    }


    public void add(Product product) {
        if (!isValidProduct(product)) {
            return;
        }
        this.products.add(product);
    }


    public void changeQuantity(String product, int quantity) {
        if (quantity < 0) {
            throw new IllegalArgumentException();
        }
        this.findByLabel(product).setQuantity(quantity);
    }


    public Product find(int index) {
        return this.products.get(index);
    }


    public Product findByLabel(final String label) {
        return this.products
                .stream()
                .filter(product -> product.label.equals(label))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }


    public Iterable<Product> findFirstByAlphabeticalOrder(int count) {
        if (count <= 0 || count > this.getCount()) {
            return new ArrayList<>();
        }

        return this.products.stream()
                .sorted()
                .limit(count)
                .collect(Collectors.toList());
    }

    public Iterable<Product> findAllInRange(double lo, double hi) {
        if (lo < 0 || hi < 0) {
            return new ArrayList<>();
        }

        return this.products
                .stream()
                .filter(product -> product.getPrice() > lo && product.getPrice() <= hi)
                .sorted((p1, p2) -> Double.compare(p2.getPrice(), p1.getPrice()))
                .collect(Collectors.toList());
    }


    public Iterable<Product> findAllByPrice(double price) {
        if (price < 0) {
            return new ArrayList<>();
        }

        return this.products
                .stream()
                .filter(product -> product.getPrice() == price)
                .collect(Collectors.toList());
    }


    public Iterable<Product> findFirstMostExpensiveProducts(int count) {
        if(count <= 0 || this.products.isEmpty()){
            throw new IllegalArgumentException();
        }

        return this.products
                .stream()
                .sorted((p1, p2) -> Double.compare(p2.getPrice(), p1.getPrice()))
                .limit(count)
                .collect(Collectors.toList());
    }


    public Iterable<Product> findAllByQuantity(int quantity) {
        if(quantity < 0 || this.products.isEmpty()){
            return new ArrayList<>();
        }

        return this.products
                .stream()
                .filter(product -> product.getQuantity() == quantity)
                .collect(Collectors.toList());
    }

    public Iterator<Product> iterator() {
        return this.products.iterator();
    }

    private boolean isValidProduct(Product product) {
        if (product == null || product.label == null || product.quantity < 0 || this.contains(product)) {
            return false;
        }

        return true;
    }
}
