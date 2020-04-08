package info.xiantang.algorithm.interview;

import org.junit.Test;

public class NoTempMoveLeftOrRightTest {

    @Test
    public void testMoveLeftOrRight() {
        int[] array = {-1, 2, 3, -1, 2, 13, 123, -555, -888, 66};
        NoTempMoveLeftOrRight.move(array);
        for (int value : array) {
            System.out.println(value);

        }


    }

}
