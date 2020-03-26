package info.xiantang.jvm.generic;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * @Author: xiantang
 * @Date: 2019/8/28 13:41
 */
public class Auto {


    public static void foo1() {
        List<Integer> list = Arrays.asList(1, 2, 3, 4);
        int sum = 0;
        for (int i : list) {
            sum += i;
        }
        System.out.println(sum);
    }
    // 编译后的变化
    private static void foo2() {
        List<Integer> list = Arrays.asList(1, 2, 3, 4);
        int sum = 0;

        int i;
        for(Iterator var2 = list.iterator(); var2.hasNext(); sum += i) {
            i = (Integer)var2.next();
        }

        System.out.println(sum);
    }

    public static void main(String[] args) {
//        Integer a = 1;
//        Integer b = 2;
//        Integer c = 3;
//        Integer d = 3;
//        Integer e = 321;
//        Integer f = 321;
//        Long g = 3L;
//        System.out.println(c == d);
//        System.out.println(e == f);
//        System.out.println(c == (a+b));
//        System.out.println(c.equals(a + b));
//        System.out.println(g == (a + b));
//        System.out.println(g.equals(a + b));
        if (true) {
            System.out.println("block 1");
        } else {
            System.out.println("block 2");
        }
    }


}
