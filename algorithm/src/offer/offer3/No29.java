package offer.offer3;

/**
 * @Author: xiantang
 * @Date: 2019/7/30 22:37
 */
public class No29 {

    /**
     * 数组中有一个数字出现的次数超过数组长度的一半，
     * 请找出这个数字。例如输入一个长度为 9 的数组{1,2,3,2,2,2,5,4,2}。
     * 由于数字 2 在数组中出现了 5 次，超过数组长度的一半，因此输出 2。
     */
    public static void main(String[] args) {
        int[] arr={1,2,3,2,2,2,5,4,2};
        System.out.println(findNum(arr));
    }

    private static Integer findNum(int[] arr) {
        if (arr == null) {
            return null;
        }
        int result = arr[0];
        int count = 1;
        for (int i = 0; i < arr.length; i++) {
            if (result == arr[i]) {
                count++;
            } else if (count == 0) {
                count = 1;
                result = arr[i];
            } else {
                count--;
            }
        }
        return result;
    }

}
