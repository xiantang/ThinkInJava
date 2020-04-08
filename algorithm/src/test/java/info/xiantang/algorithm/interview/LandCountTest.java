package info.xiantang.algorithm.interview;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LandCountTest {


    @Test
    public void landCountTest() {

        int[][] lands = {{1, 1, 1, 1, 0},
                        {1, 1, 0, 1, 0},
                        {1, 1, 0, 0, 0},
                        {0, 0, 0, 0, 0}};
        int res = LandCount.find(lands);
        assertEquals(1, res);



    }
}
