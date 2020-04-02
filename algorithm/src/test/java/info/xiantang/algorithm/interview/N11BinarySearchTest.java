package info.xiantang.algorithm.interview;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class N11BinarySearchTest {

    @Test
    public void testFindMinDig() {
        int[] array = {3, 4, 5, 1, 2};

        int i = N11FindMinDigInArray.find(array);
        assertEquals(1, i);

    }
}
