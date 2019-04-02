package customlinkedlist;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import p05_CustomLinkedList.CustomLinkedList;

import static org.junit.Assert.*;

public class CustomLinkedTests {
    CustomLinkedList<Long> customLinkedList;

    @Before
    public void init(){
        customLinkedList = new CustomLinkedList<Long>();
    }


    @Test
    public void shouldReturnMinusOneOnInvalidIndexOfElement(){
        assertEquals(-1, customLinkedList.indexOf(5L));
    }

    @Test
    public void shouldReturnIndexOfItem(){
        customLinkedList.add(50L);
        assertEquals(0, customLinkedList.indexOf(50L));
    }

    @Test
    public void shouldReturnFalseWhenNotContainingElement(){
        assertFalse(customLinkedList.contains(10L));
    }

    @Test
    public void shouldReturnTrueWhenContainsElement(){
        customLinkedList.add(10L);
        assertTrue(customLinkedList.contains(10L));
    }

    @Test
    public void shouldReturnElementWhenGetByIndex(){
        customLinkedList.add(50L);
        long result = customLinkedList.get(0);
        assertEquals(50, result);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowOnNegativeIndexWhenGetByIndex(){
        customLinkedList.add(50L);
        customLinkedList.get(-20);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowOnGreaterThanCollectionCountWhenGetByIndex(){
        customLinkedList.add(50L);
        customLinkedList.get(120);
    }


    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowWhenSetOnNegativeIndex(){
        customLinkedList.add(50L);
        customLinkedList.set(-50, 10L);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowOnGreaterThanCollectionCountWhenSet(){
        customLinkedList.add(50L);
        customLinkedList.set(120, 10L);
    }

    @Test
    public void shouldSet(){
        customLinkedList.add(50L);
        customLinkedList.set(0, 10L);
        long result = customLinkedList.get(0);
        assertEquals(10L, result);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowWhenRemoveAtOnNegativeIndex(){
        customLinkedList.add(50L);
        customLinkedList.removeAt(-10);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowWhenRemoveAtOnGreaterThanCollectionIndex(){
        customLinkedList.add(50L);
        customLinkedList.removeAt(10);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldRemoveAt(){
        customLinkedList.add(50L);
        customLinkedList.removeAt(0);
        long result = customLinkedList.get(0);
        assertEquals(-1, result);
    }

    @Test
    public void shouldThrowWhenRemoveOnInvalidElement(){
        int result = customLinkedList.remove(50L);
        assertEquals(-1, result);
    }

    @Test
    public void shouldRemove(){
        customLinkedList.add(50L);
        customLinkedList.remove(50L);
        long result = customLinkedList.indexOf(50L);
        assertEquals(-1, result);
    }

    @Test
    public void shouldReturnIndexOfRemovedElement(){
        customLinkedList.add(50L);
        int result = customLinkedList.remove(50L);
        assertEquals(0, result);
    }
}
