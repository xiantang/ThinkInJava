package info.xiantang.algorithm.interview;

public class NoTempMoveLeftOrRight {
    public static void move(int[] array) {
        int left = 0;
        int right = array.length - 1;
        while (left < right) {
            while (array[left] > 0) {
                left += 1;
            }
            while (array[right] < 0) {
                right -= 1;
            }
            if (left >= right) {
                break;
            }
            int i = array[left];
            array[left] = array[right];
            array[right] = i;

        }
    }
}
