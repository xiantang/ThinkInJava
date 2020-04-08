package info.xiantang.algorithm.interview;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class No13RobotMoveRangeCountTest {

    @Test
    public void testRobotMoveRangeCount() {
        int threshold = 5;
        int rows = 10;
        int cols = 10;
        int actual = N13RobotMoveRangeCount.count(threshold,rows,cols);
        assertEquals(21, actual);
    }

}
