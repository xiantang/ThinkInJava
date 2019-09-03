package design.c1;

/**
 * @Author: xiantang
 * @Date: 2019/9/3 13:28
 */
public class BadSuspend {
    public static Object u = new Object();
    static ChangeObjectThread t1 = new ChangeObjectThread("t1");
    static ChangeObjectThread t2 = new ChangeObjectThread("t2");

    private static class ChangeObjectThread extends Thread{


        public ChangeObjectThread(String name) {
            super.setName(name);
        }

        @Override
        public void run() {
            synchronized (u) {
                System.out.println("in " + getName());
                Thread.currentThread().suspend();
                System.out.println("out " + getName());
            }
        }

        public static void main(String[] args) throws InterruptedException {
            t1.start();
            Thread.sleep(100);
            t2.start();
            t1.resume();
            // 因为时间顺序 t2 resume 先行执行 所以没有生效
            // t2 永远占用了资源
            // 名称: t2
            // 状态: RUNNABLE
            // 总阻止数: 0, 总等待数: 0
            t2.resume();
            t1.join();
            t2.join();
        }
    }
}
