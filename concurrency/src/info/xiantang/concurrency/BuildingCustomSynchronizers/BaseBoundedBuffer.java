package info.xiantang.concurrency.BuildingCustomSynchronizers;

import java.nio.BufferOverflowException;
import java.util.concurrent.ArrayBlockingQueue;

/**
 * @Author: xiantang
 * @Date: 2019/4/22 20:15
 */
public abstract class BaseBoundedBuffer<V> {
    private final V[] buf;
    private int tail;
    private int head;
    private int count;

    protected BaseBoundedBuffer(int capacity) {
        this.buf = (V[]) new Object[capacity];
    }

    protected synchronized final void doPut(V v) {
        buf[tail] = v;
        if (++tail == buf.length) {
            tail = 0;
        }
        ++count;
    }

    public synchronized final boolean isFull() {
        return count == buf.length;
    }

    public synchronized final boolean isEmpty() throws BufferOverflowException {
        return count == 0;
    }


    protected synchronized final V doTake() {
        V v = buf[head];
        buf[head] = null;
        if (++head == buf.length) {
            head = 0;
        }
        --count;
        return v;
    }




    public static void main(String[] args) throws InterruptedException {
        System.out.println(new ArrayBlockingQueue<String>(1).take());

    }


}
