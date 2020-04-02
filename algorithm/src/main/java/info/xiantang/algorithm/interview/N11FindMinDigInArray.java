package info.xiantang.algorithm.interview;

public class N11FindMinDigInArray {
    public static int find(int[] array) {
        int start = 0;
        int end = array.length - 1;
        int mid = start;
        while (array[start] > array[end]) {

            if (end - start == 1) {
                return array[end];
            }

            mid = (start + end) / 2;
            int midVal = array[mid];
            if (midVal >= array[start]) {
                start = mid;
            } else if (midVal <= array[end]) {
                end = mid;
            }
        }
        return array[mid];
    }
}
