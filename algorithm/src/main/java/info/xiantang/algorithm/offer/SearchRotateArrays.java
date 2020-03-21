package info.xiantang.algorithm.offer;

/**
 * @Author: xiantang
 * @Date: 2019/7/8 8:59
 */
public class SearchRotateArrays {
    public static void main(String[] args) {
        int[] a = {4, 5, 6, 7, 0, 1, 2};
        int target = 5;
        int left = 0;
        int right = a.length - 1;
        while (left <= right) {
            int leftVal = a[left];
            int rightVal = a[right];
            int mid = (left + right) / 2;
            int midVal = a[mid];
            if (leftVal == target) {
                System.out.println(left);
                break;
            }
            if (rightVal == target) {
                System.out.println(right);
                break;
            }
            if (midVal == target) {
                System.out.println(mid);
                break;
            }
            //{left:4, 5, 6, 7,mid: 0, 1, 2,3};
            // 说明旋转点在左边区间中
            // 所以右边区间是有序的
            if (leftVal > midVal) {
                if (target > midVal && target < leftVal) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
                //{left:4, 5, 6, mid:7, 0, 1, 2};
                // 说明旋转点在右边区间中
                // 说明左边区间是有序的
            } else {
                if (target > leftVal && target < midVal) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }

        }
    }
}
