package info.xiantang.algorithm.interview;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class NoQsort2Test {

    @Test
    public void test() {
        int[] first = {1};
        NoQsort.sort(first);
        assertArrayEquals(new int[]{1}, first);
        int[] second = {4, 5, 21, 9, 7, 8, 6};
        NoQsort.sort(second);
        assertArrayEquals(new int[]{4, 5,  6, 7, 8,9, 21}, second);
    }

}
