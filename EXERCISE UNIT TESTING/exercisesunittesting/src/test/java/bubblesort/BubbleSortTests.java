package bubblesort;

import org.junit.Assert;
import org.junit.Test;
import p04_BubbleSortTest.Bubble;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class BubbleSortTests {

    @Test
    public void shouldReturnSameOn1LengthArray(){
        int[] actual = {1};
        int[] result = {1};
        Bubble.sort(result);
        assertArrayEquals(actual, result);
    }

    @Test
    public void shouldReturnSorted(){
        int[] actual = new int[]{1, 2, 3, 4};
        int[] result = new int[]{4, 3, 2, 1};

        Bubble.sort(result);

        assertArrayEquals(actual, result);
    }

    @Test
    public void shouldReturnSortedWithRepeatingElements(){
        int[] actual = new int[]{1, 1, 4, 5, 5, 9};
        int[] result = new int[]{5, 4, 5, 1, 9, 1};

        Bubble.sort(result);

        assertArrayEquals(actual, result);
    }

    @Test
    public void shouldSortNegativeNumbers(){
        int[] actual = new int[]{-10, -5, -3, -1};
        int[] result = new int[]{-5, -1, -10, -3};

        Bubble.sort(result);

        assertArrayEquals(actual, result);
    }

    @Test
    public void shouldSortNegativePositiveNumbers(){
        int[] actual = new int[]{-10, -5, -3, -1, 0, 3, 5, 10};
        int[] result = new int[]{-5, -1, -10, -3, 0, 10, 3, 5};

        Bubble.sort(result);

        assertArrayEquals(actual, result);
    }
}
