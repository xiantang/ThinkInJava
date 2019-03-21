package c11;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class ComType implements Comparable {
    int i;
    int j;

    public ComType(int i, int j) {
        this.i = i;
        this.j = j;
    }
    public String toString() {
        return "[i = " + i + ", j = " + j + "]";
    }

    @Override
    public int compareTo(Object o) {
        int rvi = ((ComType) o).i;
        return (i < rvi ? -1 : (i == rvi ? 0 : 1));
    }
    private static Random r = new Random(); public static Generator generator() {

        return new Generator() {

            public Object next() {

                return new ComType(r.nextInt(100), r.nextInt(100));

            }

        };
    }

    public static void main(String[] args) {
        ComType[] a = new ComType[10];
        Arrays2.fill(a, generator());

        System.out.println("before sorting, a = " + Arrays.asList(a));
        Arrays.sort(a);
        System.out.println("after sorting, a = " + Arrays.asList(a));
    }

}
