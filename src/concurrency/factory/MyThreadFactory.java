package concurrency.factory;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MyThreadFactory implements ThreadFactory {
    private final String poolName;

    public MyThreadFactory(String poolName) {
        this.poolName = poolName;
    }

    @Override
    public Thread newThread(Runnable r) {
//        return new MyAppThread(r,poolName);
        return null;

    }

    class A {
        int i = 0;
        public synchronized void
        add() {
            i++;
        }
    }

    private A a = new A();
    public void testIPlusPlus() throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(2);
        class Task implements Runnable {

            @Override
            public void run() {
                for(int j=0; j<10000000; j++) {
                    a.add();

                }
                countDownLatch.countDown();
            }
        }
        new Thread(new Task()).start();
        new Thread(new Task()).start();
        countDownLatch.await();
        System.out.println(a.i);
    }

    public static void main(String[] args) throws InterruptedException {
        Lock lock = new ReentrantLock();
        new MyThreadFactory("dasd").testIPlusPlus();
    }
}
