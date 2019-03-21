package c11;

import java.util.Iterator;

public class Printer {
    static void printAll(Iterator e) {
        while (e.hasNext()) {
            System.out.println(e.next());
        }
    }
}
