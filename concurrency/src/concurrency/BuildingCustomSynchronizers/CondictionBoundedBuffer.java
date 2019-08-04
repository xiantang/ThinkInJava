package concurrency.BuildingCustomSynchronizers;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author: xiantang
 * @Date: 2019/4/23 21:10
 */
public class CondictionBoundedBuffer<T> {
    private static final int BUFFER_SIZE = 5;
    protected final Lock lock = new ReentrantLock();
    // 条件谓语 count<item.length
    private final Condition notFull = lock.newCondition();
    // 条件谓语 count>0
    private final Condition notEmpty = lock.newCondition();
    private final T[] items = (T[]) new Object[BUFFER_SIZE];
    private int tail,head,count;

    public void put(T x) {
        lock.lock();
        try {
            while (count == items.length) {
                notFull.await();
            }
            items[tail] = x;
            if (++tail == items.length) {
                tail = 0;
            }
            ++count;
            // 发送信号停止
            notEmpty.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public T take() throws InterruptedException {
        lock.lock();
        try {
            while (count == 0) {
                notEmpty.await();
            }
            T x = items[head];
            items[head] = null;
            if (++head == items.length) {
                head = 0;
            }
            --count;
            notFull.signal();
            return x;
        }
        finally {
            lock.unlock();
        }


    }

}
