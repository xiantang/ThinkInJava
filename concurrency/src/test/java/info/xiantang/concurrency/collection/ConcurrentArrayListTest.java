package info.xiantang.concurrency.collection;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class ConcurrentArrayListTest {

    @Test
    public void testPut() {
        ConcurrentArrayList<String> concurrentArrayList = new ConcurrentArrayList<>(1024);
        concurrentArrayList.add("xiantang");
        ArrayList<String> strings = new ArrayList<>();
        strings.add("ddd");
        strings.add("bbbb");
        concurrentArrayList.addAll(strings);
        int actual = concurrentArrayList.getWriteCursor();
        assertEquals(2, actual);
    }


    @Test
    public void testPutWithThreads() throws InterruptedException {
        ConcurrentArrayList<String> concurrentArrayList = new ConcurrentArrayList<>(1024);
        Thread[] threads = new Thread[6];
        for (int i = 0; i < 6; i++) {
            threads[i] = new Thread(() -> {
                ArrayList<String> strings = new ArrayList<>();
                strings.add("ddd");
                strings.add("bbbb");
                concurrentArrayList.addAll(strings);
            });
        }
        for (Thread thread : threads) {
            thread.start();
        }
        for (Thread thread : threads) {
            thread.join();
        }
        assertEquals(11, concurrentArrayList.getWriteCursor());

    }


}
