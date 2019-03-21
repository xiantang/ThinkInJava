package c12;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class ReadOnly {
    static Collection<String> data =
            new ArrayList<String>();

    public static void main(String[] args) {
        data.add("aaa");
        Collection<String> c = Collections.unmodifiableList(new ArrayList<>(data));
        System.out.println(c);
        ((List<String>) c).add("one");
    }
}
