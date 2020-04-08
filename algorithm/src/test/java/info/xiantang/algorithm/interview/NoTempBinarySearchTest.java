package info.xiantang.algorithm.interview;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class NoTempBinarySearchTest {


    @Test
    public void test() {
        int[] a = {1, 2, 5, 6, 7, 9, 10, 13, 26};
        int index = NoTempBinarySearch.find(a, 6);
        assertEquals(3, index);
        int index1 = NoTempBinarySearch.find(a, 1);
        assertEquals(0, index1);


    }
}
