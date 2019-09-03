package design.c1;

/**
 * @Author: xiantang
 * @Date: 2019/9/3 15:17
 */
public class BadLockOnInteger implements Runnable {
    public static Integer i = 0;
    static BadLockOnInteger integer = new BadLockOnInteger();

    @Override
    public void run() {
        for (int j = 0; j < 1000000; j++) {
            synchronized (integer) {
                // 会被反编译成为 Integer.valueOf()
                // 本质就是创建一个 Integer 对象
                // 将引用赋值给i
                /**
                 *  public static Integer valueOf(int i) {
                 *         if (i >= IntegerCache.low && i <= IntegerCache.high)
                 *             return IntegerCache.cache[i + (-IntegerCache.low)];
                 *         return new Integer(i);
                 *     }
                 */
                i++;
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(integer);
        Thread t2 = new Thread(integer);
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println(i);
    }
}
