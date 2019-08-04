package algorithm.offer4;

/**
 * @Author: xiantang
 * @Date: 2019/7/31 21:14
 */
public class No43 {
    /**
     * 把 n 个骰子仍在地上，所有骰子朝上一面的点数之和为 s，
     * 输入 n，打印出 s 的所有可能的值出现的概率
     */
    // TODO 需要review
    public static void main(String[] args) {

        printProbability(6);
    }



    private static void printProbability(int num) {
        int maxSum = num * 6;
        // 数组长度为maxSum - num + 1
        // 是因为如果 两个骰子是抛不出 1的
        // 同理三个抛不出 1 2
        int[] nums = new int[maxSum - num + 1];
        for (int i = 1; i <=6 ; i++) {
            // 对于第一个骰子 我们从1 遍历到 6 表示
            // 进入方法后表示这个骰子 投中的值
            probability(num, num, i, nums);
        }
        double total = Math.pow(6.0, 6.0);
        for (int i = num; i <= maxSum; ++i) {
            double ratio = (double)nums[i - num] / total;
            System.out.println(i + "   " + ratio);
        }

    }

    private static void probability(int origin, int current, int sum, int[] nums) {
        // 如果current == 1 说明就只剩下一个骰子
        // 这个骰子对应的值的位置+1
        // 至于为什么要这样选择是这样的
        // 如果我们有两个骰子 那么 索引10对应的值是12 因为两个骰子不存在1
        // 如果我们抛到12 那么就会对10 的数据自增
        if (current == 1) {
            nums[sum - origin]++;
        } else {
            for (int i = 1; i <= 6; i++) {
                probability(origin, current - 1, sum + i, nums);
            }

        }
    }
}
