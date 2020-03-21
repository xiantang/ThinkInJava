package info.xiantang.concurrency.design.c1;

/**
 * @Author: xiantang
 * @Date: 2019/9/3 11:30
 */
public class SimpleWn {
    final static Object object = new Object();

    public static class T1 extends Thread {
        @Override
        public void run() {
            synchronized (object) {
                System.out.println(System.currentTimeMillis() + ":T1 start!");
                try {
                    System.out.println(System.currentTimeMillis() + ":T1 wait for object");
                    object.wait();
                    System.out.println(System.currentTimeMillis() + ":T1 get object lock!");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(System.currentTimeMillis() + ":T1 end!");
            }
        }
    }

    public static class T2 extends Thread {
        @Override
        public void run() {
            synchronized (object) {
                System.out.println(System.currentTimeMillis() + ":T2 notify one thread");
                // T1 在收到通知的时候 还是会先尝试获取obj 的对象锁
                object.notify();
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {

                }

            }
        }
    }

    public static void main(String[] args) {
        new T1().start();
        new T2().start();
    }
}
