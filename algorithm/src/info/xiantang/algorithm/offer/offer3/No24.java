package info.xiantang.algorithm.offer.offer3;

public class No24 {
    /**
     * 输入一个整数数组，
     * 判断该数组是不是某二叉搜索树的后序遍历的结果。
     * 如果是则返回 true，否则返回 false。
     * 假设输入的数组的任意两个数字都互不相同
     */
    public static void main(String[] args) {
        int[] array={5,7,6,9,11,10,8};
// int[] array={7,4,6,5};
        boolean b=verfiySequenceOfBST(array,0,6);
        System.out.println(b);
    }

    private static boolean verfiySequenceOfBST(int[] array, int start, int end) {
        if (start == end) {
            return true;
        }
        int last = array[end];
        int i = start;
        for (; i <= end; i++) {
            if (array[i] > last) {
                break;
            }
        }
        int j = i;
        for (; j < end; j++) {
            if (array[j] < last) {
                return false;
            }
        }
        return verfiySequenceOfBST(array, start, i - 1) && verfiySequenceOfBST(array, i, end - 1);


    }

}
