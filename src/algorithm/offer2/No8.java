package algorithm.offer2;

public class No8 {
    /**
     * 把一个数组最开始的若干个元素搬到数组的末尾，
     * 我们称之为数组的旋转。输入一个递增排序的数组
     * 的一个旋转，输出旋转数组的最小元素。例如数组
     * {3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为 1。
     */
    // TODO 需要复习 这道题做的很巧妙
    public static void main(String[] args) {
        int[] arr={3,4,5,1,2};
        System.out.println(findMin(arr));
    }

    private static int findMin(int[] arr) {
        int left = 0;
        int right = arr.length - 1;
        int indexMid = left;
        while (arr[left] >= arr[right]) {
            if (right - left == 1) {
                indexMid = right;
                break;
            }
            int mid = (left + right) / 2;
            // 如果mid>lefe 说明旋转点不在区间中
            if (arr[mid] >= arr[left]) {
                left = mid;
            } else{
                right = mid;
            }
        }
        return arr[indexMid];
    }

}
