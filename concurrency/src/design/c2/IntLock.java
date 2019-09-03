package design.c2;

import concurrency.BuildingCustomSynchronizers.ReentranLock;

/**
 * @Author: xiantang
 * @Date: 2019/9/3 15:40
 */
public class IntLock extends Thread {
    public static ReentranLock lock1 = new ReentranLock();
    public static ReentranLock lock2 = new ReentranLock();
    int lock;

    public IntLock(int lock) {
        this.lock = lock;
    }

    @Override
    public void run() {
        try {
            // 构造逆向顺序锁 方便构造死锁
            if (lock == 1) {
                lock1.lockInterruptibly();
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {}
                lock2.lockInterruptibly();
                System.out.println("thread 1 do some thing");
            } else {
                lock2.lockInterruptibly();
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {}
                lock1.lockInterruptibly();
                System.out.println("thread 2 do some thing");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        finally {
            if (lock == 1) {
                lock1.unlock();
            } else {
                lock2.unlock();
            }
            System.out.println(Thread.currentThread().getId() + ": 线程退出");
        }

    }

    public static void main(String[] args) throws InterruptedException {
        IntLock r1 = new IntLock(1);
        IntLock r2 = new IntLock(2);
        Thread t1 = new Thread(r1);
        Thread t2 = new Thread(r2);
        t1.start();
        t2.start();
        Thread.sleep(1000);
        t2.interrupt();

    }
}
