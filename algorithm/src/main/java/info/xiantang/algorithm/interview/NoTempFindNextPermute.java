package info.xiantang.algorithm.interview;

public class NoTempFindNextPermute {
    public static int[] find(int[] array) {
        int index = -1;
        int end = array.length - 1;
        for (int i = end; i > 0; i--) {
            if (array[i] > array[i - 1]) {
                index = i - 1;
                break;

            }
        }
        if (index == -1) {
            return null;
        }

        int i = array[index];
        array[index] = array[end];
        array[end] = i;
        index += 1;
        while ( index < end) {
            int i1 = array[index];
            array[index] = array[end];
            array[end] = i1;
            end--;
            index++;
        }
        return array;
    }
}
