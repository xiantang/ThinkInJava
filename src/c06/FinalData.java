package c06;

import java.util.Random;

public class FinalData {
    private static Random rand = new Random();
    private String id;

    public FinalData(String id) {
        this.id = id;
    }

    private final int VAL_ONE = 9;
    private static final int VAL_TWO = 99;
    private static final int VAL_THREE = 39;
    private  final int i4 = rand.nextInt(20);
    static  final int i5 = rand.nextInt(20);
    private Value v1 = new Value(11);
    private final Value v2 = new Value(22);
    private static final Value v3 = new Value(33);

    private final int[] a = {1, 2, 3, 4, 5, 6};

    @Override
    public String toString() {
        return id + ": " + "i4 = " + i4 + ", i5 = " + i5;
    }

    public static void main(String[] args) {
        FinalData fd1 = new FinalData("fd1");
        fd1.v2.i++;
        System.out.println(fd1.v2.i);
        // 可以改变
        fd1.v1 = new Value(9);
        System.out.println(fd1.v1.i);
        for (int i = 0; i < fd1.a.length; i++) {
            fd1.a[i]++;
//            fd1.v2 = new Value(0); // 不能改变引用
//            fd1.v3 = new Value(1); // 不能

//            System.out.println(fd1.a[i]);
        }
        FinalData fd2 = new FinalData("fd2");
        System.out.println(fd1);
        System.out.println(fd2);
    }
}
