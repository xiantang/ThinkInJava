package info.xiantang.algorithm.interview;

import org.junit.Test;

public class NoTempPrintMatrixCycleTest {
    @Test
    public void test() {
        int[][] array = {{1, 2, 3, 4},
                        {4, 5, 6, 7},
                        {7, 8, 9, 10},
                        {11, 12, 13, 14}};
        NoTempPrintMatrixCycle.cycle(array);


    }
}
