package c11;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

public class SimpleCollection {
    public static void main(String[] args) {
        Collection c = new ArrayList();
//        HashMap
        for (int i = 0; i < 10; i++) {
            c.add(Integer.toString(i));
        }
        Iterator it = c.iterator();
        while (it.hasNext()) System.out.println(it.next());
    }
}
