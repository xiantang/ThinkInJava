package info.xiantang.concurrency.design.c1;

/**
 * @Author: xiantang
 * @Date: 2019/9/3 11:12
 */
public class InterruptTest {
    public static void main(String[] args) throws InterruptedException {
        // 思考一个问题 会不会中断
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    // 判断当前线程是否中断
                    if (Thread.currentThread().isInterrupted()) {
                        System.out.println("Interrupted!");
                        break;
                    }
                    Thread.yield();
                }
            }
        });
        t1.start();
        Thread.sleep(2000);
        t1.interrupt();

    }
}
