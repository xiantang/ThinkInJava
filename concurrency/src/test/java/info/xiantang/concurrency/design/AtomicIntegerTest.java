package info.xiantang.concurrency.design;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AtomicIntegerTest {


    @Test
    public void testAddAndGet() {
        AtomicInteger atomicInteger = new AtomicInteger(11);
        atomicInteger.incrementAndGet();
        int actual = atomicInteger.get();
        assertEquals(12, actual);

    }


    @Test
    public void manyThreadWithIncrementAndGet() throws InterruptedException {
        AtomicInteger atomicInteger = new AtomicInteger(0);
        Thread[] ts = new Thread[10];
        for (int k = 0; k < 10; k++) {
            ts[k] = new Thread(new AddThread(atomicInteger));
        }
        for (int k = 0; k < 10; k++) {
            ts[k].start();
        }
        for (int k = 0; k < 10; k++) {
            ts[k].join();
        }
        assertEquals(100000, atomicInteger.get());

    }


    public static class AddThread extends Thread {
        private AtomicInteger i;

        public AddThread(AtomicInteger i) {
            this.i = i;
        }

        @Override
        public void run() {
            /**
             * // 自增操作是一个死循环
             * // 因为CAS操作是不一定成功的
             *
             *  public final int incrementAndGet() {
             *         for (;;) {
             *             int current = get();
             *             int next = current + 1;
             *             if (compareAndSet(current, next))
             *                 return next;
             *         }
             *     }
             *
             *
             * // Unsafe 就是封装了一些指针的操作
             * public final boolean compareAndSet(int expect, int update) {
             *         return unsafe.compareAndSwapInt(this, valueOffset, expect, update);
             *     }
             *
             * 第一个参数是给定的对象 o
             * offset 是对象头部的偏移值
             * except 是期望值
             * x 是需要设置的值
             * public final native boolean compareAndSwapInt(
             *      Object o , long offset, int expect, int x);
             */
            for (int k = 0; k < 10000; k++) {
                i.incrementAndGet();
            }
        }
    }

}
