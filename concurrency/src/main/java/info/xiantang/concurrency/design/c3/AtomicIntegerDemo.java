package info.xiantang.concurrency.design.c3;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author: xiantang
 * @Date: 2019/9/5 11:48
 */
public class AtomicIntegerDemo {
    static AtomicInteger i = new AtomicInteger();

    public static class AddThread implements Runnable {
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

    public static void main(String[] args) throws InterruptedException {
        Thread[] ts = new Thread[10];
        for (int k = 0; k < 10; k++) {
            ts[k] = new Thread(new AddThread());
        }
        for (int k = 0; k < 10; k++) {
            ts[k].start();
        }
        for (int k = 0; k < 10; k++) {
            ts[k].join();
        }
        System.out.println(i);
        
    }
}
