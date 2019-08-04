package concurrency.BuildingCustomSynchronizers;

import java.util.concurrent.TimeUnit;

/**
 * @Author: xiantang
 * @Date: 2019/4/22 20:50
 */
public class BoundedBuffer<V> extends BaseBoundedBuffer<V> {
    public BoundedBuffer(int capacity) {
        super(capacity);
    }

    public synchronized void put(V v) throws InterruptedException {
        while (isFull()) {
            wait();
        }
        boolean wasEmpty = isEmpty();
        doPut(v);
        // 条件通知
        if (wasEmpty) {
            notifyAll();
        }
    }

    public synchronized V take() throws InterruptedException {
        while (isEmpty()) {
            wait();
        }
        V v = doTake();
        notifyAll();
        return v;
    }

    public static void main(String[] args) throws InterruptedException {
        final BaseBoundedBuffer<String> baseBoundedBuffer = new BoundedBuffer<String>(5);
        new Thread() {
            @Override
            public void run() {
                try {
                    System.out.println(((BoundedBuffer<String>) baseBoundedBuffer).take());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }.start();

        new Thread() {
            @Override
            public void run() {
                try {
                    TimeUnit.SECONDS.sleep(1);
                    ((BoundedBuffer<String>) baseBoundedBuffer).put("aaaa");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }.start();



    }

}

