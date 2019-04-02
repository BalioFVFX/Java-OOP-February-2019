package dbtests;

import javafx.scene.chart.PieChart;
import org.junit.Before;
import org.junit.Test;
import p01_Database.Database;

import javax.naming.OperationNotSupportedException;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class DatabaseTests {

    Database validDb;

    @Before
    public void createValidDB() throws OperationNotSupportedException {
        this.validDb = new Database(1);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void shouldThrowOn17Integers() throws OperationNotSupportedException {
        int[] ints = new int[10];
        Database database = new Database(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void shouldThrowOnNegativeIntegers() throws OperationNotSupportedException {
        Database database = new Database();
    }

    @Test(expected = OperationNotSupportedException.class)
    public void shouldThrowWhenAddNull() throws OperationNotSupportedException {
        validDb.add(null);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void shouldThrowOnRemoveOnEmptyDB() throws OperationNotSupportedException {
        validDb.remove();
        validDb.remove();
    }

    @Test
    public void shouldIncrementSizeWhenAddOperation() throws OperationNotSupportedException {
        validDb.add(10);
        assertEquals(2, validDb.getElements().length);
    }

    @Test
    public void shouldReturnArray() {
        assertEquals(Integer[].class, validDb.getElements().getClass());
    }

    @Test
    public void shouldStoreElementsInArrayAfterInitialization() throws OperationNotSupportedException {
        Database database = new Database(1, 2, 3);
        Integer[] arr = new Integer[]{1, 2, 3};

        assertArrayEquals(arr, database.getElements());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void shouldThrowWhenAdding17Elements() throws OperationNotSupportedException {
        for (int i = 0; i < 17; i++) {
            validDb.add(1);
        }
    }

    @Test
    public void shouldDecreaseCountWhenRemoving() throws OperationNotSupportedException {
        Database database = new Database(1, 2, 30);

        database.remove();
        assertEquals(2, database.getElements().length);
    }



}
