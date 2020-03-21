package info.xiantang.concurrency.design.c2;


import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author: xiantang
 * @Date: 2019/9/3 15:59
 */
public class FairLock implements Runnable{
    /**
     * lock() 获得锁
     * lockInterruptibly() 获得锁 但是优先响应中断
     * tryLock() 尝试获得锁 失败就直接返回
     * unlock() 释放锁
     */
    public static ReentrantLock fairLock = new ReentrantLock(true);

    @Override
    public void run() {
        while (true) {
            try {
                fairLock.lock();
                System.out.println(Thread.currentThread().getName() + " 获得锁");
            }finally {
                fairLock.unlock();
            }

        }
    }

    public static void main(String[] args) {
        FairLock r1 = new FairLock();
        Thread t1 = new Thread(r1, "Thread_t1");
        Thread t2 = new Thread(r1, "Thread_t2");
        t1.start();
        t2.start();
    }
}
