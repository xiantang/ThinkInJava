package c11;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class InfiniteRecursion {
    public String toString() {
        return " InfiniteRecursion address: " + super.toString() + "\n";
    }

    public static void main(String[] args) {
        List v = new ArrayList();
        for (int i = 0; i < 10; i++) v.add(new InfiniteRecursion());
        System.out.println(v);

    }
}
