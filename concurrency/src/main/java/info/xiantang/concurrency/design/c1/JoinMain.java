package info.xiantang.concurrency.design.c1;

/**
 * @Author: xiantang
 * @Date: 2019/9/3 14:06
 */
public class JoinMain {
    public volatile static int i = 0;

    public static class AddTread extends Thread {
        @Override
        public void run() {
            for (i = 0; i < 100000; i++);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        AddTread at = new AddTread();
        at.start();
        // 如果没有join 在AddThread 还没开始 i 的值已经输出了
        // 使用 join 之后表示主线程愿意等待 AddTread

        /**
         * 当前线程一直监听被监听的线程是否执行完成
         * 执行完成就会调用 notifyAll() 通知所有
         * 等待的线程放行
         * while (isAlive()) {
         *                 wait(0);
         *}
         */
        at.join();
        System.out.println(i);
    }
}
