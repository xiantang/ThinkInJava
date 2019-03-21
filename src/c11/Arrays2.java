package c11;

import java.util.*;

public class Arrays2 {
    public static String toString(boolean[] a) {
        StringBuffer result = new StringBuffer("[");
        for (int i = 0; i < a.length; i++) {
            result.append(a[i]);
            if (i < a.length - 1) {
                result.append(", ");
            }
        }
        result.append("] ");
        return result.toString();
    }

    public static String toString(int[] a) {
        StringBuffer result = new StringBuffer("[");
        for (int i = 0; i < a.length; i++) {
            result.append(a[i]);
            if (i < a.length - 1) {
                result.append(", ");
            }
        }
        result.append("] ");
        return result.toString();
    }

    public static void fill(Object[] a, Generator gen) {
        fill(a, 0, a.length, gen);
    }

    public static void fill(boolean[] a, BooleanGenerator gen) {
        fill(a, 0, a.length, gen);
    }

    public static void fill(int[] a, IntGenerator gen) {
        fill(a, 0, a.length, gen);
    }

    private static void fill(int[] a, int i, int length, IntGenerator gen) {
        for (int j = i; j < length; j++)
            a[j] = gen.next();
    }

    public static void fill(Object[] a, int from, int to, Generator gen) {
        for (int i = from; i < to; i++) {
            a[i] = gen.next();
        }
    }

    public static void fill(boolean[] a, int from, int to, BooleanGenerator gen) {

        for (int i = from; i < to; i++)
            a[i] = gen.next();


    }


    private static Random r = new Random();

    public static class RandBooleanGenerator implements BooleanGenerator {


        public boolean next() {

            return r.nextBoolean();
        }
    }

    public static class RandIntGenerator implements IntGenerator {

        private int mod = 10000;

        public RandIntGenerator() {
        }

        public RandIntGenerator(int modulo) {
            mod = modulo;
        }

        public int next() {
            return r.nextInt(mod);
        }
    }

    private static String ssource =

            "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
    private static char[] src = ssource.toCharArray();

    public static class RandCharGenerator implements CharGenerator {

        public char next() {

            return src[r.nextInt(src.length)];

        }
    }

    public static class RandStringGenerator implements Generator {
        private int len;
        private RandCharGenerator cg = new RandCharGenerator();

        public RandStringGenerator(int length) {
            len = length;
        }

        @Override
        public Object next() {
            char[] buf = new char[len];
            for (int i = 0; i < len; i++) buf[i] = cg.next();
            return new String(buf);
        }
    }

    public static void main(String[] args) {

        boolean[] a1 = new boolean[7];
        Arrays2.fill(a1, new RandBooleanGenerator());
        System.out.println(Arrays2.toString(a1));
        ;
        boolean[] a2 = new boolean[10];
        Arrays2.fill(a2, new RandBooleanGenerator());
        System.out.println(Arrays2.toString(a2));
        System.arraycopy(a1, 0, a2, 0, a1.length);
        System.out.println(Arrays2.toString(a2));

    }

}
