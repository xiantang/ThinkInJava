package c11;

import java.util.Arrays;

public class ComparingArrays {
    public static void main(String[] args) {
        int[] a1 = new int[10];
        int[] a2 = new int[10];
        Arrays.fill(a1, 47);
        Arrays.fill(a2, 47);
        String[] s1 = new String[5];
        System.out.println(Arrays.equals(a2,a1));
        Arrays.fill(s1, "Hi");
        String[] s2 = {"Hi", "Hi", "Hi", "Hi", "Hi"}; System.out.println(Arrays.equals(s1, s2));
    }
}
