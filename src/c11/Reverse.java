package c11;

import java.util.Arrays;
import java.util.Collections;

public class Reverse {
    public static void main(String[] args) {
        ComType[] a = new ComType[10];
        Arrays2.fill(a,ComType.generator());
        System.out.println(
                "before sorting, a = " + Arrays.asList(a)
        );
        Arrays.sort(a, Collections.reverseOrder());
        System.out.println(
                "after sorting, a = " + Arrays.asList(a));


    }
}
