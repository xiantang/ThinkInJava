package design.c2;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author: xiantang
 * @Date: 2019/9/3 16:17
 */
public class PrintABC {

    private static volatile String status = "A";
    public static ReentrantLock lock = new ReentrantLock();
    private static Condition condition = lock.newCondition();

    static class ThreadABC implements Runnable {
        private String name;

        ThreadABC(String name) {
            this.name = name;
        }

        @Override
        public void run() {
            while (true) {
                try {
                    lock.lock();
                    if (status.equals(name)) {
                        System.out.println(name);
                        if ("A".equals(status)) {
                            status = "B";
                        } else if ("B".equals(status)) {
                            status = "C";
                        } else {
                            status = "A";
                        }
                        condition.signalAll();
                    } else {
                        condition.awaitUninterruptibly();
                    }
                } finally {
                    lock.unlock();
                }
            }
        }
    }

    public static void main(String[] args) {
        Thread a = new Thread(new ThreadABC("A"));
        Thread b = new Thread(new ThreadABC("B"));
        Thread c = new Thread(new ThreadABC("C"));
        a.start();
        b.start();
        c.start();

    }
}
