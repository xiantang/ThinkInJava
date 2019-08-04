package algorithm.offer4;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: xiantang
 * @Date: 2019/7/31 21:01
 */
public class No41 {
    /**
     * 输入一个递增排序的数组和一个数字 s，
     * 在数组中查找两个数，使得它们的和正好是 s。
     * 如果有多对数字的和等于 s，输出任意一对即可
     */
    public static void main(String[] args) {
        int[] data={1,2,4,7,11,15};
        System.out.println(findNumberWithSum(data, 15));
    }

    private static boolean findNumberWithSum(int[] data, int i) {
        int start = 0;
        int end = data.length - 1;
        boolean found = false;
        while (start < end) {
            if (data[start] + data[end] == i) {
                System.out.println(data[start]);
                System.out.println(data[end]);
                found = true;
                return found;
            } else if (data[start] + data[end] > i) {
                end--;
            } else {
                start++;
            }
        }
        return false;
    }

}
