package info.xiantang.concurrency.design.c2;


import java.util.concurrent.locks.LockSupport;

/**
 * @Author: xiantang
 * @Date: 2019/9/3 18:20
 */
public class LockSupportIntDemo {
    public static Object u = new Object();

    static ChangeObjectThread t1 = new ChangeObjectThread("t1");
    static ChangeObjectThread t2 = new ChangeObjectThread("t2");

    public static class ChangeObjectThread extends Thread {
        public ChangeObjectThread(String name) {
            super.setName(name);
        }

        @Override
        public void run() {
            synchronized (u) {
                System.out.println("in " + getName());
                // 处于waiting
                // 名称: t1
                // 状态: WAITING
                // 总阻止数: 0, 总等待数: 1
                //
                // 堆栈跟踪:
                // sun.misc.Unsafe.park(Native Method)
                // java.util.concurrent.locks.LockSupport.park(LockSupport.java:304)
                // main.java.concurrency.design.c2.LockSupportIntDemo$ChangeObjectThread.run(LockSupportIntDemo.java:26)
                //    - 已锁定 java.lang.Object@1af5
                LockSupport.park(this);
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        t1.start();
        Thread.sleep(100);
        t2.start();
        // 我们无法保证unpark()方法发生在park()方法之后
        // 因为LockSupport 为每个线程准备了一个许可
        // 如果许可可用 park() 函数会立马返回
        // 如果不可用 park() 函数会阻塞
        // 而 unpark() 会使一个许可可用
//        LockSupport.unpark(t1);
//        LockSupport.unpark(t2);
//        t1.join();
//        t2.join();
    }


}
