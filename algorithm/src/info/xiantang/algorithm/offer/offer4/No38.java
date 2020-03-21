package info.xiantang.algorithm.offer.offer4;

public class No38 {
    /**
     * 统计一个数字在排序数组中出现的次数。
     * 例如输入排序数组{1,2,3,3,3,3,4,5}和数字 3，
     * 由于 3 在这个数组中出现了 4 次，因此输出 4
     */
    public static void main(String[] args) {

        int[] array = {1, 2, 3, 3, 3, 3, 4, 5};
        System.out.println(getNumberOfK(array, 5));
    }

    private static int getNumberOfK(int[] array, int i) {
        return getLastK(array, i) - getFirstK(array, i) + 1;
    }

    private static int getLastK(int[] array, int i) {
        int left = 0;
        int right = array.length - 1;
        while (left < right) {
            int mid = (left + right) / 2;
            if (array[mid] > i) {
                right = mid;
            } else if (array[mid] < i) {
                left = mid + 1;
            } else {
                if (mid == array.length - 1) {
                    return mid;
                } else if (array[mid + 1] != i) {
                    return mid;
                } else {
                    left = mid + 1;
                }
            }
        }
        return 0;
    }

    private static int getFirstK(int[] array, int i) {
        int left = 0;
        int right = array.length - 1;
        while (left < right) {
            int mid = (left + right) / 2;
            if (array[mid] > i) {
                right = mid;
            } else if (array[mid] < i) {
                left = mid + 1;
            } else {
                if (mid == 0) {
                    return 0;
                } else if (array[mid - 1] != i) {
                    return mid;
                } else {
                    right = mid;
                }
            }
        }
        return 0;
    }

}
