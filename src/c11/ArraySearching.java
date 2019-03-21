package c11;

import com.xiantang.mypackage.A;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArraySearching {
    public static void main(String[] args) {

//        int[] a = new int[100];
//        Arrays2.RandIntGenerator gen = new Arrays2.RandIntGenerator(1000);
//        Arrays2.fill(a, gen);
//        Arrays.sort(a);
//        System.out.println( "Sorted array: " + Arrays2.toString(a));
        int[] a = new int[100];
        Arrays2.RandIntGenerator gen = new Arrays2.RandIntGenerator(1000);
        Arrays2.fill(a, gen);
        Arrays.sort(a);

        System.out.println( "Sorted array: " + Arrays2.toString(a));
        while (true) {
            int r = gen.next();
            int location = Arrays.binarySearch(a, r);
            if (location >= 0) {
                System.out.println("Location of " + r + " is " + location + ", a[" + location + "] = " + a[location]);
                break;
            }
        }
    }
}
