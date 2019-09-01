package offer.sort;

/**
 * @Author: xiantang
 * @Date: 2019/9/1 10:14
 */
public class HeapSort {

    public static void main(String[] args) {
        int[] nums = {16,7,3,20,17,8};
        headSort(nums);
        for (int num : nums) {
            System.out.print(num + " ");
        }
    }

    private static void headSort(int[] nums) {
        // 获得他的长度
        int N = nums.length;
        // 从最后一个非叶子节点开始调整
        for (int i = (N / 2)-1; i >= 0; i--) {
            sink(nums, i, N);
        }
        N -= 1;
        while (N >= 1) {
            exch(nums, 0, N);
            sink(nums, 0, N);
            N--;
        }

    }

    private static void sink(int[] nums, int k, int n) {
        while (2*k+1 < n) {
            // 考虑一下为index 为0的情况
            int j = 2*k+1;
            // 如果两个元素第一个比第二个大
            // j 就保留为第一个
            // 否则 j 保留为第二个
            if (j + 1 < n) {
                if (k < n && nums[j] < nums[j + 1]) {
                    j += 1;
                }
            }
            if (nums[k] < nums[j]) {
                // 交换元素
                exch(nums, k, j);
                // 继续向下推断
                k = j;
            }
            else{
                break;
            }

        }
    }

    private static void exch(int[] nums, int k, int j) {
        int tmp = nums[k];
        nums[k] = nums[j];
        nums[j] = tmp;
    }

}
