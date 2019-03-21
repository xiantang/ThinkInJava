package c11;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FillTest {
    private static Generator sg = new Arrays2.RandStringGenerator(7);

    public static void main(String[] args) {
        List list = new ArrayList();
        Collections2.fill(list, sg, 25);
        System.out.println(list+"\n");
        List list2 = new ArrayList();
        Collections2.fill(list2,Collections2.capitals,25);
        System.out.println(list2);
        Set set = new HashSet();
        Collections2.fill(set, sg, 25);
        System.out.println(set);
    }
}
