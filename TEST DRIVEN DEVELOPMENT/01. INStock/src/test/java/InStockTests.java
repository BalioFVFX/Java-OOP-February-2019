import org.junit.Before;
import org.junit.Test;

import java.util.Iterator;

import static org.junit.Assert.*;

public class InStockTests {

    private static final String DEFAULT_PRODUCT_NAME = "Label";
    private static final double DEFAULT_PRODUCT_PRICE = 2.0;
    private static final int DEFAULT_PRODUCT_QUANTITY = 5;

    private static final String SECOND_PRODUCT_NAME = DEFAULT_PRODUCT_NAME + 2;
    private static final double SECOND_PRODUCT_PRICE = DEFAULT_PRODUCT_PRICE + 2.0;
    private static final int SECOND_PRODUCT_QUANTITY = DEFAULT_PRODUCT_QUANTITY + 2;

    private static final String THIRD_PRODUCT_NAME = DEFAULT_PRODUCT_NAME + 3;
    private static final double THIRD_PRODUCT_PRICE = DEFAULT_PRODUCT_PRICE + 4.0;
    private static final int THIRD_PRODUCT_QUANTITY = DEFAULT_PRODUCT_QUANTITY + 3;

    private static final int SEEDED_CART_COUNT = 3;
    private static final String[] SORTED_PRODUCT_NAMES = {DEFAULT_PRODUCT_NAME, SECOND_PRODUCT_NAME, THIRD_PRODUCT_NAME};


    private Product[] descendingProducts;
    private Product[] productsWithSamePricesAndQuantity;


    private Product defaultProduct;
    private Product secondProduct;
    private Product thirdProduct;
    private Instock stocks;


    @Before
    public void init() {
        this.defaultProduct = new Product(DEFAULT_PRODUCT_NAME, DEFAULT_PRODUCT_PRICE, DEFAULT_PRODUCT_QUANTITY);
        this.secondProduct = new Product(SECOND_PRODUCT_NAME, SECOND_PRODUCT_PRICE, SECOND_PRODUCT_QUANTITY);
        this.thirdProduct = new Product(THIRD_PRODUCT_NAME, THIRD_PRODUCT_PRICE, THIRD_PRODUCT_QUANTITY);
        this.descendingProducts = new Product[]{thirdProduct, secondProduct, defaultProduct};

        this.productsWithSamePricesAndQuantity = new Product[]
                {
                        defaultProduct,
                        new Product(DEFAULT_PRODUCT_NAME + 4, 2.0, DEFAULT_PRODUCT_QUANTITY),
                        new Product(DEFAULT_PRODUCT_NAME + 5, 2.0, DEFAULT_PRODUCT_QUANTITY),
                        new Product(DEFAULT_PRODUCT_NAME + 6, 2.0, DEFAULT_PRODUCT_QUANTITY),
                };

        this.descendingProducts = new Product[]{thirdProduct, secondProduct, defaultProduct};
        this.stocks = new Instock();
    }

    @Test
    public void containsShouldReturnFalseWhenNotContainingProduct() {
        assertFalse(stocks.contains(defaultProduct));
    }

    @Test
    public void containsShouldReturnTrueWhenContainingProduct() {
        this.stocks.add(defaultProduct);
        assertTrue(this.stocks.contains(defaultProduct));
    }

    @Test
    public void addShouldIncrementCount() {
        this.stocks.add(defaultProduct);
        assertEquals(1, this.stocks.getCount());
    }

    @Test
    public void addShouldIncrementCountMultiple() {
        this.seedCart();
        assertEquals(SEEDED_CART_COUNT, this.stocks.getCount());
    }

    @Test
    public void addShouldNotAddNullProduct() {
        this.stocks.add(null);
        assertEquals(0, this.stocks.getCount());
    }

    @Test
    public void addShouldNotAddProductWithSameName() {
        this.stocks.add(defaultProduct);
        this.stocks.add(new Product(DEFAULT_PRODUCT_NAME, 50, 120));
        assertEquals(1, this.stocks.getCount());
    }

    @Test
    public void addShouldNotAddProductWithNegativeQuantity() {
        this.stocks.add(new Product(DEFAULT_PRODUCT_NAME, DEFAULT_PRODUCT_PRICE, -50));
        assertEquals(0, this.stocks.getCount());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void findShouldThrowOnEmpty() {
        this.stocks.find(250);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void findShouldThrowOnGreaterThanCountIndex() {
        this.seedCart();
        this.stocks.find(250);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void findShouldThrowOnNegativeIndex() {
        this.seedCart();
        this.stocks.find(-1);
    }

    @Test
    public void findShouldReturnCorrectProduct() {
        this.seedCart();
        Product actual = this.stocks.find(0);
        assertEquals(defaultProduct, actual);
    }

    @Test(expected = IllegalArgumentException.class)
    public void changeQuantityShouldThrowWhenEmptyCart() {
        this.stocks.changeQuantity(DEFAULT_PRODUCT_NAME, 10);
    }

    @Test(expected = IllegalArgumentException.class)
    public void changeQuantityShouldThrowWhenProductIsNotInStock() {
        this.seedCart();
        this.stocks.changeQuantity("Not in the cart", 10);
    }

    @Test(expected = IllegalArgumentException.class)
    public void changeQuantityShouldThrowOnNullProductName() {
        this.seedCart();
        this.stocks.changeQuantity(null, 10);
    }


    @Test(expected = IllegalArgumentException.class)
    public void changeQuantityShouldThrowOnNegativeQuantity() {
        this.seedCart();
        this.stocks.changeQuantity(DEFAULT_PRODUCT_NAME, -50);
    }

    @Test
    public void changeQuantityShouldChangeProductQuantity() {
        this.seedCart();
        this.stocks.changeQuantity(DEFAULT_PRODUCT_NAME, 5000);
        Product actual = this.stocks.find(0);
        assertEquals(5000, actual.quantity);
    }

    @Test(expected = IllegalArgumentException.class)
    public void findByLabelShouldThrowOnEmptyCart() {
        this.stocks.findByLabel(DEFAULT_PRODUCT_NAME);
    }

    @Test(expected = IllegalArgumentException.class)
    public void findByLabelShouldThrowOnNullLabel() {
        this.seedCart();
        this.stocks.findByLabel(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void findByLabelShouldThrowWhenNotContainingProductWithLabel() {
        this.seedCart();
        this.stocks.findByLabel("Not in the cart");
    }

    @Test
    public void findByLabelShouldReturnCorrect() {
        this.seedCart();
        Product actual = this.stocks.findByLabel(DEFAULT_PRODUCT_NAME);
        assertEquals(defaultProduct, actual);
    }

    @Test
    public void findFirstByAlphabeticalOrderShouldReturnEmptyCollectionOnEmpty() {
        Iterable<Product> actual = this.stocks.findFirstByAlphabeticalOrder(1);
        assertFalse(actual.iterator().hasNext());
    }

    @Test
    public void findFirstByAlphabeticalOrderShouldReturnEmptyCollectionOnOutOfRangePositive() {
        this.seedCart();
        Iterable<Product> actual = this.stocks.findFirstByAlphabeticalOrder(50);
        assertFalse(actual.iterator().hasNext());
    }

    @Test
    public void findFirstByAlphabeticalOrderShouldReturnEmptyCollectionOnOutOfRangeNegative() {
        this.seedCart();
        Iterable<Product> actual = this.stocks.findFirstByAlphabeticalOrder(-50);
        assertFalse(actual.iterator().hasNext());
    }

    @Test
    public void findFirstByAlphabeticalOrderShouldReturnEmptyCollectionOnZeroCount() {
        this.seedCart();
        Iterable<Product> actual = this.stocks.findFirstByAlphabeticalOrder(0);
        assertFalse(actual.iterator().hasNext());
    }

    @Test
    public void findFirstByAlphabeticalOrderShouldReturnCorrectOnSortedCart() {
        this.stocks.add(defaultProduct);
        this.stocks.add(secondProduct);
        this.stocks.add(thirdProduct);

        Iterable<Product> actual = this.stocks.findFirstByAlphabeticalOrder(3);

        assertTrue(actual.iterator().hasNext());

        Iterator<Product> actualProductIterator = actual.iterator();
        for (int i = 0; i < this.SORTED_PRODUCT_NAMES.length; i++) {
            assertEquals(SORTED_PRODUCT_NAMES[i], actualProductIterator.next().label);
        }

        assertFalse(actualProductIterator.hasNext());
    }

    @Test
    public void findFirstByAlphabeticalOrderShouldReturnCorrectOnUnSortedCart() {
        this.seedCart();

        Iterable<Product> actual = this.stocks.findFirstByAlphabeticalOrder(3);

        assertTrue(actual.iterator().hasNext());

        Iterator<Product> actualProductIterator = actual.iterator();
        for (int i = 0; i < InStockTests.SORTED_PRODUCT_NAMES.length; i++) {
            assertEquals(SORTED_PRODUCT_NAMES[i], actualProductIterator.next().label);
        }

        assertFalse(actualProductIterator.hasNext());
    }

    @Test
    public void findAllInPriceRangeShouldReturnEmptyCollectionForEmptyCart() {
        Iterator<Product> actual = this.stocks.findAllInRange(1, 20).iterator();

        assertFalse(actual.hasNext());
    }

    @Test
    public void findAllInPriceRangeShouldReturnEmptyCollectionForLowerEndNegative() {
        this.seedCart();
        Iterator<Product> actual = this.stocks.findAllInRange(-10, 20).iterator();

        assertFalse(actual.hasNext());
    }

    @Test
    public void findAllInPriceRangeShouldReturnEmptyCollectionForHigherEndNegative() {
        this.seedCart();
        Iterator<Product> actual = this.stocks.findAllInRange(1, -20).iterator();

        assertFalse(actual.hasNext());
    }

    @Test
    public void findAllInPriceRangeShouldReturnEmptyCollectionForParametersOutOfCartPrice() {
        this.seedCart();
        Iterator<Product> actual = this.stocks.findAllInRange(20, 50).iterator();

        assertFalse(actual.hasNext());
    }

    @Test
    public void findAllInPriceRangeShouldReturnCorrectResult() {
        this.seedCart();
        Iterator<Product> actual = this.stocks.findAllInRange(1, 10).iterator();

        for (int i = 0; i < descendingProducts.length; i++) {
            assertEquals(descendingProducts[i], actual.next());
        }

        assertFalse(actual.hasNext());
    }

    @Test
    public void findAllInPriceRangeShouldReturnCorrectResultWith2Products() {
        this.stocks.add(secondProduct);
        this.stocks.add(defaultProduct);

        Iterator<Product> actual = this.stocks.findAllInRange(1, 4).iterator();

        for (int i = 1; i < descendingProducts.length; i++) {
            assertEquals(descendingProducts[i], actual.next());
        }

        assertFalse(actual.hasNext());
    }

    @Test
    public void findAllInPriceRangeShouldReturnCorrectResultWhenLowerParameterIsExclusive() {
        this.stocks.add(secondProduct);
        this.stocks.add(thirdProduct);

        Iterator<Product> actual = this.stocks.findAllInRange(2, 10).iterator();

        for (int i = 0; i < descendingProducts.length - 1; i++) {
            assertEquals(descendingProducts[i], actual.next());
        }
        assertFalse(actual.hasNext());
    }

    @Test
    public void findAllInPriceRangeShouldReturnCorrectResultWhenEndParameterIsInclusive() {
        this.seedCart();
        Iterator<Product> actual = this.stocks.findAllInRange(1, 6).iterator();

        for (int i = 0; i < descendingProducts.length; i++) {
            assertEquals(descendingProducts[i], actual.next());
        }

        assertFalse(actual.hasNext());
    }

    @Test
    public void findAllByPriceShouldReturnEmptyOnEmptyCollection() {
        assertFalse(this.stocks.findAllByPrice(2.0).iterator().hasNext());
    }

    @Test
    public void findAllByPriceShouldReturnEmptyOnNegativePrice() {
        this.seedCart();
        assertFalse(this.stocks.findAllByPrice(-2.0).iterator().hasNext());
    }

    @Test
    public void findAllByPriceShouldReturnEmptyOnProductWithNoSuchPrice() {
        this.seedCart();
        assertFalse(this.stocks.findAllByPrice(10).iterator().hasNext());
    }

    @Test
    public void findAllByPriceShouldReturnOneProductByPrice() {
        this.seedCart();
        Iterator<Product> actual = this.stocks.findAllByPrice(2.0).iterator();

        assertEquals(this.defaultProduct, actual.next());
        assertFalse(actual.hasNext());
    }

    @Test
    public void findAllByPriceShouldReturnMultipleProductByPrice() {
        this.seedWithProductsWithSamePriceAndQuantity();

        Iterator<Product> actual = this.stocks.findAllByPrice(2.0).iterator();

        for (int i = 0; i < this.productsWithSamePricesAndQuantity.length; i++) {
            assertEquals(productsWithSamePricesAndQuantity[i], actual.next());
        }

        assertFalse(actual.hasNext());
    }

    @Test(expected = IllegalArgumentException.class)
    public void findFirstMostExpensiveProductsShouldThrowOnNegativeCount(){
        this.seedCart();
        this.stocks.findFirstMostExpensiveProducts(-10);
    }
    @Test(expected = IllegalArgumentException.class)
    public void findFirstMostExpensiveProductsShouldThrowOnZeroCount(){
        this.seedCart();
        this.stocks.findFirstMostExpensiveProducts(0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void findFirstMostExpensiveProductsShouldThrowOnEmptyCart(){
        this.stocks.findFirstMostExpensiveProducts(3);
    }

    @Test
    public void findFirstMostExpensiveProductsReturnCorrectWith1Count(){
        this.seedCart();

        Iterator<Product> actual = this.stocks.findFirstMostExpensiveProducts(1).iterator();

        assertEquals(thirdProduct, actual.next());

        assertFalse(actual.hasNext());
    }

    @Test
    public void findFirstMostExpensiveProductsReturnCorrectResult(){
        this.seedCart();

        Iterator<Product> actual = this.stocks.findFirstMostExpensiveProducts(3).iterator();

        for (int i = 0; i < this.descendingProducts.length; i++) {
            assertEquals(descendingProducts[i], actual.next());
        }

        assertFalse(actual.hasNext());
    }

    @Test
    public void findAllByQuantityShouldReturnEmptyForEmptyCollection(){
        assertFalse(this.stocks.findAllByQuantity(3).iterator().hasNext());
    }

    @Test
    public void findAllByQuantityShouldReturnEmptyForNegativeQuantity(){
        this.seedCart();
        assertFalse(this.stocks.findAllByQuantity(-3).iterator().hasNext());
    }

    @Test
    public void findAllByQuantityShouldReturn1Product(){
        this.seedCart();
        Iterator<Product> actual = this.stocks.findAllByQuantity(5).iterator();
        assertEquals(defaultProduct, actual.next());
        assertFalse(actual.hasNext());
    }

    @Test
    public void findAllByQuantityShouldReturnMultipleProduct(){
        this.seedWithProductsWithSamePriceAndQuantity();
        Iterator<Product> actual = this.stocks.findAllByQuantity(5).iterator();

        for (int i = 0; i < this.productsWithSamePricesAndQuantity.length; i++) {
            assertEquals(this.productsWithSamePricesAndQuantity[i], actual.next());
        }

        assertFalse(actual.hasNext());
    }

    @Test
    public void getIteratorShouldReturnEmptyForEmptyCart(){
        assertFalse(this.stocks.iterator().hasNext());
    }

    @Test
    public void iteratorShouldReturnCorrectResult(){
        this.seedWithProductsWithSamePriceAndQuantity();
        Iterator<Product> actual = this.stocks.iterator();

        for (int i = 0; i < this.productsWithSamePricesAndQuantity.length; i++) {
            assertEquals(productsWithSamePricesAndQuantity[i], actual.next());
        }

        assertFalse(actual.hasNext());
    }


    private void seedCart() {
        this.stocks.add(defaultProduct);
        this.stocks.add(thirdProduct);
        this.stocks.add(secondProduct);
    }

    private void seedWithProductsWithSamePriceAndQuantity() {
        for (int i = 0; i < this.productsWithSamePricesAndQuantity.length; i++) {
            this.stocks.add(productsWithSamePricesAndQuantity[i]);
        }
    }
}
