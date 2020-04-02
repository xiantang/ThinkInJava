package info.xiantang.algorithm.interview;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class No3FindDupNumUnModifyTest {

    @Test
    public void findDupNumUnModify() {
        int[] nums = {2, 3, 1, 0, 2, 5, 3};
        boolean actual = No4FindDupNumUnModify.findUnmodified(nums);
        assertTrue(actual);
        int[] nums2 = {2, 3, 1, 0, 5, 4};
        boolean actual2 = No4FindDupNumUnModify.findUnmodified(nums2);
        assertFalse(actual2);


    }


}
