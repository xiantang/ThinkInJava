package info.xiantang.algorithm.interview;

import org.junit.Test;

import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;

public class No4FindInTwoMatrixArrayTest {
    @Test
    public void testFindInTwoMatrixArray() {
        int[][] arr =
                    {{1, 2, 8, 9},
                    {2, 4, 9, 12},
                    {4, 7, 10, 13},
                    {6, 8, 11, 15}};
        boolean result = No5FindInTwoMatrixArray.find(arr,7);
        assertTrue(result);
        boolean result1 = No5FindInTwoMatrixArray.find(arr,5);
        assertFalse(result1);
    }


}
