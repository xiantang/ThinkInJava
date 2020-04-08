package info.xiantang.algorithm.interview;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class NoTempFindNextPermuteTest {

    @Test
    public void testFindNextPermute() {
        int[] inOrder = {9, 5, 4, 3, 1};
        int[] res = NoTempFindNextPermute.find(inOrder);
        assertArrayEquals(null, res);
        int[] preOrder = {1, 2, 3, 5, 4};
        int[] res1 = NoTempFindNextPermute.find(preOrder);
        assertArrayEquals(new int[]{1, 2, 4, 3, 5}, res1);
    }
}
