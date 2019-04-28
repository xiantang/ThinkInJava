package JavaConcurrency.ExplicitLocks;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import static java.util.concurrent.TimeUnit.NANOSECONDS;

/**
 * @Author: xiantang
 * @Date: 2019/4/22 19:45
 */
public class TimedLocking {
    private Lock lock = new ReentrantLock();

    public boolean trySendOnSharedLine(String message,
                                       long timeout, TimeUnit unit) throws InterruptedException {
        long naosToLock = unit.toNanos(timeout);
        if (!lock.tryLock(naosToLock, NANOSECONDS)) {
            return false;
        }
        try {
            return sendOnSharedLine(message);
        }finally {
            lock.unlock();
        }
    }
    private boolean sendOnSharedLine(String message) {
        /* send something */
        return true;
    }

    long estimatedNanosToSend(String message) {
        return message.length();
    }

}
