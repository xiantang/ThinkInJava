package algorithm.offer3;

/**
 * @Author: xiantang
 * @Date: 2019/7/30 23:03
 */
public class No31 {
    /**
     * 输入一个整型数组，数组里有正数，也有负数。
     * 数组中一个或连续的多个整数组成一个子数组。
     * 求所有子数组的和的最大值。要求时间复杂度为 O(n）
     */
    public static void main(String[] args) {
        int[] arr={1,-2,3,10,-4,7,2,-5};
        System.out.println(maxSub(arr));
    }

    /**
     * 贪心就完事了
     * @param arr
     * @return
     */
    private static int maxSub(int[] arr) {
        int sum = 0;
        int max = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            if (sum < 0) {
                sum = 0;
            } else if (sum > max) {
                max = sum;
            }
        }
        return max;
    }
}
