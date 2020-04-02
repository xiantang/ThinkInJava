package info.xiantang.algorithm.interview;

import java.util.Arrays;

class No4FindDupNumUnModify {
    static boolean findUnmodified(int[] nums) {
        int length = nums.length;
        int[] another = new int[length];
        Arrays.fill(another, -1);
        for (int num : nums) {
            if (another[num] == num) {
                return true;
            } else {
                another[num] = num;
            }

        }
        return false;
    }
}
