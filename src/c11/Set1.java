package c11;

import java.util.*;

public class Set1 {
    static void fill(Set set) {
        set.addAll(Arrays.asList(
                "one two three four five six seven".split(" "))
        );
    }

    public static void test(Set s) {
        System.out.println(s.getClass().getName().replaceAll("\\w+\\.", ""));
        fill(s);
        fill(s);
        fill(s);
        System.out.println(s);
        s.addAll(s);
        s.add("one");
        s.add("one");
        s.add("one");
        System.out.println(s);
        System.out.println("s.contains(\"one\"): " + s.contains("one"));
    }

    public static void main(String[] args) {
        test(new HashSet());
        test(new TreeSet());
        test(new LinkedHashSet());
    }

}
