package algorithm;

import java.util.Arrays;

public class TwoValuetoK {
    void s(int[] value, int target) {
        Arrays.sort(value);
        int left = 0;
        int right = value.length-1;
        while (left < right) {
            if (value[left] + value[right] == target) {
                System.out.println(left + "  " + right);
                right--;
            }
            if (value[left] + value[right] < target) {
                left++;
            } else {
                right--;
            }

        }
    }
}
