package concurrency;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class AttemptLocking {
    private  Lock lock = new ReentrantLock();

    public void untimed() {
        boolean captured = lock.tryLock();
        try {
            System.out.println("tryLock():"+captured);
        }finally {
            if (captured)
                lock.unlock();
        }
    }

    public void timed() {
        boolean captured = false;
        try {
            // 等待两秒
            // 尝试获取锁
            captured = lock.tryLock(2, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            throw new RuntimeException();
        }
        try {
            System.out.println("tryLock(2,TimeUnit.SECOND):" + captured);
        }finally {
            if (captured) {
                lock.unlock();
            }
        }
    }

    public static void main(String[] args) {
//        EvenChecker.test(new );
        final AttemptLocking al = new AttemptLocking();
        // 主线程获取锁
        al.untimed();
        al.timed();
//        al.lock.lock();
        new Thread() {
            {
                setDaemon(true);
            }

            @Override
            public void run() {
                // 锁住
                // 创建一个线程去获取锁
                al.lock.lock();
                System.out.println("acquired");

            }
        }.start();
        Thread.yield();
        al.untimed();
        al.timed();
    }
}
