package iteratorTest;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import p03_IteratorTest.ListIterator;

import javax.naming.OperationNotSupportedException;

import java.util.List;

import static org.junit.Assert.*;

public class IteratorTests {

    private ListIterator listIterator;

    @Before
    public void createValidListIterator() throws OperationNotSupportedException {
        listIterator = new ListIterator("First", "Second");
    }

    @Test(expected = OperationNotSupportedException.class)
    public void shouldThrowOnInitWithNullParam() throws OperationNotSupportedException {
        new ListIterator(null);
    }

    @Test(expected = IllegalStateException.class)
    public void shouldThrowOnPrintWithEmptyCollection() throws OperationNotSupportedException {
        ListIterator listIterator = new ListIterator();
        listIterator.print();
    }

    @Test
    public void shouldReturnTrueWhenMove(){
        assertTrue(listIterator.move());
    }

    @Test
    public void shouldReturnTrueWhenHasNext(){
        assertTrue(listIterator.hasNext());
    }

    @Test
    public void shouldReturnFalseWhenHasNoMove(){
        listIterator.move();
        assertFalse(listIterator.move());
    }

    @Test
    public void shouldReturnFalseWhenHasNoNext(){
        listIterator.move();
        assertFalse(listIterator.hasNext());
    }

    @Test
    public void shouldReturnTheFirstElementWithoutMove(){
        assertEquals("First", listIterator.print());
    }

    @Test
    public void shouldReturnSecondElementWithMove(){
        listIterator.move();
        assertEquals("Second", listIterator.print());
    }

}
