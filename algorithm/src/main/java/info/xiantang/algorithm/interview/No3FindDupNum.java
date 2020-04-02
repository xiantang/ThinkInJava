package info.xiantang.algorithm.interview;

public class No3FindDupNum {
    public static boolean find(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            // 确保当前索引下的是对的
            while (nums[i] != i) {
                // 如果相等说明已经重复了
                if (nums[nums[i]] == nums[i]) {
                    return true;
                }
                // 当前的
                int num = nums[i];
                // 当前所在索引的
                int num1 = nums[num];
                // 交换
                nums[i] = num1;
                nums[num] = num;
            }
        }
        return false;
    }


}
