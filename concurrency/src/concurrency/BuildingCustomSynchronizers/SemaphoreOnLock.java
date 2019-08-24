package concurrency.BuildingCustomSynchronizers;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author: xiantang
 * @Date: 2019/4/23 21:27
 */
public class SemaphoreOnLock {
    private final Lock lock = new ReentrantLock();
    private final Condition permitsAvailable = lock.newCondition();
    private int permitsd;


    public SemaphoreOnLock(int permitsd) {
        lock.lock();
        try {
            this.permitsd = permitsd;
        }finally {
            lock.unlock();
        }
    }

    public void acquire() throws InterruptedException {
        lock.lock();
        try {
            while (permitsd <= 0) {
                permitsAvailable.await();
            }
            --permitsd;
        }finally {
            lock.unlock();
        }
    }


    public void release() {
        lock.lock();
        try {
            ++permitsd;
            permitsAvailable.signal();
        }finally {
            lock.unlock();
        }
    }
}
