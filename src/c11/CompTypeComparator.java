package c11;


import java.util.Arrays;
import java.util.Comparator;

public class CompTypeComparator implements Comparator {
    @Override
    public int compare(Object o1, Object o2) {
        int j1 = ((ComType)o1).j;
        int j2 = ((ComType)o2).j;
        return (j1 < j2 ? -1 : (j1 == j2 ? 0 : 1));
    }

    public static void main(String[] args) {
        ComType[] a = new ComType[10];
        Arrays2.fill(a, ComType.generator());
        System.out.println(
                "before sorting, a = " + Arrays.asList(a));
        // 你看这个人 他好像一条🐶哦
        Arrays.sort(a,new CompTypeComparator());
        System.out.println(
                "after sorting, a = " + Arrays.asList(a));

    }
}
