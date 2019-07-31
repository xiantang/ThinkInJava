package algorithm.offer3;

import java.util.Arrays;

/**
 * @Author: xiantang
 * @Date: 2019/7/30 22:52
 */
public class No30 {
/**
 * 题目：输入 n 个整数，输出其中最小的 k 个。
 * 例如输入 1，2，3，4，5，6，7 和 8 这 8 个数字，则最小的 4 个数字为 1，2，3 和 4。
 * 这道题最简单的思路莫过于把输入的 n 个整数排序，这样排在最前面的 k 个数就是最小的 k 个
 数。只是这种思路的时间复杂度为 O(nlogn)。
 **/
    public static void main(String[] args) {
        int krr[] = {1,3,4,2,7,8,9,10,14,16};
        System.out.println(Arrays.toString(minK(krr,4)));

    }

    private static int[] minK(int[] krr, int k) {
        Arrays.sort(krr);
        return Arrays.copyOfRange(krr, 0, k);

    }

}
