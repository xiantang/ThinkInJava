package c11;

import java.util.Collection;
import java.util.Map;

public class Collections2 {
    public static void
    fill(Collection c, Generator gen, int count) {
        for (int i = 0; i < count; i++)
            c.add(gen.next());
    }

    public static void
    fill(Map m, MapGenerator gen, int count) {
        for (int i = 0; i < count; i++) {
            Pair p = gen.next();
            m.put(p.key, p.value);
        }
    }

    public static class
    RandStringPairGenerator implements MapGenerator {
        private Arrays2.RandStringGenerator gen;

        public RandStringPairGenerator(int len) {
            gen = new Arrays2.RandStringGenerator(len);
        }

        @Override
        public Pair next() {
            return new Pair(gen.next(), gen.next());
        }
    }

    public static RandStringPairGenerator rsp =
            new RandStringPairGenerator(10);

    public static class
    StringPairGenerator implements MapGenerator {
        private int index = -1;
        private String[][] d;

        public StringPairGenerator(String[][] d) {
            this.d = d;
        }

        @Override
        public Pair next() {
            index = (index + 1) % d.length;
            return new Pair(d[index][0], d[index][1]);
        }

        public StringPairGenerator reset() {
            index = -1;
            return this;
        }
    }

    public static StringPairGenerator geography = new StringPairGenerator(CountryCapitals.pairs);

    public static class StringGenerator implements Generator {
        private String[][] d;
        private int position;
        private int index = -1;

        public StringGenerator(String[][] data, int pos) {
            d = data;
            position = pos;
        }

        public Object next() { // Force the index to wrap:

            index = (index + 1) % d.length;
            return d[index][position];
        }

        public StringGenerator reset() {
            index = -1;
            return this;
        }

    } // Use a predefined dataset:

    public static StringGenerator countries = new StringGenerator(CountryCapitals.pairs, 0);
    public static StringGenerator capitals = new StringGenerator(CountryCapitals.pairs, 1);
}
