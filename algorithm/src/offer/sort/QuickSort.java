package offer.sort;

import java.util.Arrays;

/**
 * @Author: xiantang
 * @Date: 2019/8/31 19:02
 */
public class QuickSort {
    private static int part(int[] array, int lo, int hi) {
        // 找到第一个为基准值
        int key = array[lo];
        // 分别找出两个索引指向左边和右边
        int i = lo;
        int j = hi;
        // 条件是从两边走
        while (i < j) {

            // 7     6     4     5     9     3
            // 7     6     4     5     [3 i] [9 j]
            // 先从左向右走找到第一个大于基准值的
            // 所以会省略掉第一个值 因为第一个值等于基准值
            while (i < j && array[i] <= key) {
                i++;
            }
            // 然后从右向左走找到第一个小于基准值
            while (i < j && array[j] > key) {
                j--;
            }

            if (i < j) {
                int p = array[i];
                array[i] = array[j];
                array[j] = p;
            }
        }
        // 将第一个值和最后一个比基准值小的交换
        // 就达到了左边小右边大的结果
        int p = array[i];
        array[i] = array[lo];
        array[lo] = p;
        return i;

    }


    private static void qsort(int[] array, int lo, int hi) {
        if (lo > hi) {
            return;
        }
        int index = part(array, lo, hi);
        qsort(array, lo, index - 1);
        qsort(array, index + 1, hi);
    }

    public static void main(String[] args) {
        int[] array = {7, 6, 4, 5, 9, 3};
        qsort(array, 0, array.length - 1);
        System.out.println(Arrays.toString(array));

    }


}
