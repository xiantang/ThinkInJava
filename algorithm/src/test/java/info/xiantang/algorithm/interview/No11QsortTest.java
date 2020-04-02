package info.xiantang.algorithm.interview;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class No11QsortTest {

    @Test
    public void testQsort() {
        int[] first = {1};
         No11Qsort.sort(first);
        assertArrayEquals(new int[]{1}, first);
        int[] second = {4, 5, 21, 9, 7, 8, 6};
        No11Qsort.sort(second);
        assertArrayEquals(new int[]{4, 5,  6, 7, 8,9, 21}, second);

    }

}
