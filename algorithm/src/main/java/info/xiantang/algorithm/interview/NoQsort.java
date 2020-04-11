package info.xiantang.algorithm.interview;

public class NoQsort {
    public static void sort(int[] array) {
        int start = 0;
        int end = array.length - 1;
        sort(array, start, end);
    }

    private static void sort(int[] array, int start, int end) {
        if (end - start < 1) {
            return;
        }
        int mid = array[start];
        int left = start;
        int right = end;
        while (left < right) {
            while (array[left] < mid && left <right) {
                left++;
            }
            while (array[right] >= mid && right > left) {
                right--;
            }
            if (left >= right) {
                break;
            }
            int i = array[left];
            array[left] = array[right];
            array[right] = i;
        }

        sort(array, start, left - 1);
        sort(array, left + 1, end);

    }
}
