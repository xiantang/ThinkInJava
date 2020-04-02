package info.xiantang.algorithm.interview;

public class No11Qsort {
    public static void sort(int[] array) {


        sort(array, 0, array.length - 1);
    }

    private static void sort(int[] array, int start, int end) {
        if (end - start <= 0) {
            return;
        }
        int midVal = array[start];
        swap(array, start, end);
        int small = start - 1;
        for (int i = start; i < end; i++) {
            if (array[i] < midVal) {
                ++small;
                if (small != i) {
                    swap(array, small, i);
                }
            }
        }
        small++;
        swap(array, small, end);
        sort(array, start, small - 1);
        sort(array, small + 1, end);
    }

    private static void swap(int[] array, int low, int hi) {
        int smallVal = array[low];
        array[low] = array[hi];
        array[hi] = smallVal;
    }

}
