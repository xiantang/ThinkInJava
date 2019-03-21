package c11;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class Collection1 {
    public static void main(String[] args) {
        Collection c = new ArrayList();
        Collections2.fill(c, Collections2.countries, 5);
        ((ArrayList) c).add("ten");
        ((ArrayList) c).add("eleven");
        System.out.println(c);
        String[] str = (String[])c.toArray(new String[1]);
        System.out.println("Collections.max(c) = " + Collections.max(c));
        System.out.println("Collections.max(c) = " + Collections.min(c));
    }
}
