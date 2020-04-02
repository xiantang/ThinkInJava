package info.xiantang.algorithm.interview;

import org.junit.Test;
import static org.junit.Assert.*;
public class No3FindDupNumTest {

    @Test
    public void testFindDupNum() {
        int[] nums = {2, 3, 1, 0, 2, 5, 3};
        boolean actual = No3FindDupNum.find(nums);
        assertTrue(actual);
        int[] nums2 = {2, 3, 1, 0, 5, 4};
        boolean actual2 = No3FindDupNum.find(nums2);
        assertFalse(actual2);

    }


}
