package info.xiantang.algorithm.interview;

public class NoTempBinarySearch {
    public static int find(int[] array, int target) {
        int left = 0;
        int right = array.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (array[mid] == target) {
                return mid;
            }
            if (array[mid] > target) {
                right = mid -1;
            } else {
                left = mid +1;
            }
        }

        return -1;
    }
}
