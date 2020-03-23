package info.xiantang.concurrency.design.c1;

/**
 * @Author: xiantang
 * @Date: 2019/9/3 11:19
 */
public class InterruptTestV2 {
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
                    try {
                        Thread.sleep(2000);
                        // 当线程休眠的时候 如果被终端就会产生这个异常
                    } catch (InterruptedException e) {
                        System.out.println("Interrupted When Sleep");
                        // 标记设置中断状态
                        Thread.currentThread().interrupt();
                    }
                }
            }
        });
        t1.start();
        Thread.sleep(1000);
        t1.interrupt();

    }
}
