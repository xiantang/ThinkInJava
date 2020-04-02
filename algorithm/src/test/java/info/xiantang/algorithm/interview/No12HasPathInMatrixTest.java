package info.xiantang.algorithm.interview;

import org.junit.Test;

import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;

public class No12HasPathInMatrixTest {
    @Test
    public void testHasPathInMatrix() {
        char[][] matrix = new char[][]{
                {'a', 'b', 't', 'g'},
                {'c', 'f', 'c', 's'},
                {'j', 'd', 'e', 'h'}
        };

        boolean result1 = No12HasPathInMatrix.find(matrix,"bfce");
        assertTrue(result1);
        boolean result2 = No12HasPathInMatrix.find(matrix,"abfb");
        assertFalse(result2);
    }


}
