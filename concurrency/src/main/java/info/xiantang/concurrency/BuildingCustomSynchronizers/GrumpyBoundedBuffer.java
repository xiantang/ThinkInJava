package info.xiantang.concurrency.BuildingCustomSynchronizers;

import java.nio.BufferOverflowException;

/**
 * @Author: xiantang
 * @Date: 2019/4/22 20:35
 */
public class GrumpyBoundedBuffer<V> extends BaseBoundedBuffer<V> {
    public GrumpyBoundedBuffer(int capacity) {
        super(capacity);
    }

    public synchronized void put(V v) throws BufferOverflowException {
        if (isFull()) {
            throw new BufferOverflowException();
        }
        doPut(v);
    }

    public synchronized V take() throws BufferEmptyException {
        if (isEmpty()) {
            throw new BufferEmptyException();
        }
        return doTake();
    }




}
