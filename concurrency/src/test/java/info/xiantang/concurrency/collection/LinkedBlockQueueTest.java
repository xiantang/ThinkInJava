package info.xiantang.concurrency.collection;


import org.junit.Test;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;

public class LinkedBlockQueueTest {
    @Test
    public void testLinkedBlockQueuePutWillOutBound() throws InterruptedException {
        final LinkedBlockQueue<Integer> queue = new LinkedBlockQueue<>(3);
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    TimeUnit.MILLISECONDS.sleep(300);
                    queue.take();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
        queue.put(3);
        queue.put(3);
        queue.put(3);
        queue.put(3);
        int actual = queue.size();
        assertEquals(3, actual);

    }


    @Test
    public void testTakeEmptyWillBlock() throws InterruptedException {
        final LinkedBlockQueue<Integer> queue = new LinkedBlockQueue<>(3);

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    TimeUnit.MILLISECONDS.sleep(300);
                    queue.put(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
        int actual = queue.take();
        assertEquals(1, actual);
    }

}
