package concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class EvenChecker implements Runnable {
    private IntGenerator generator;
    private final int id;

    public EvenChecker(IntGenerator generator, int id) {
        this.generator = generator;
        this.id = id;
    }

    @Override
    public void run() {
        // 没有失败 就一直循环
        while (!generator.isCanceled()) {
            int val = generator.next();
//            System.out.println(val);
            // 如果失败就直接返回
            if (val %2 !=0){
                System.out.println(val + " not even");
                // 关闭线程
                generator.cancel();
            }

        }
    }

    public static void test(IntGenerator gp,int count) {
        ExecutorService exec = Executors.newCachedThreadPool();
        for (int i = 0; i < count; i++) {
            exec.execute(new EvenChecker(gp, i));
        }
        exec.shutdown();
    }

    public static void test(IntGenerator gp) {
        test(gp, 10);
    }
}
