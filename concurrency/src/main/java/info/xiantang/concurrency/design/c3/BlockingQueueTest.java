package info.xiantang.concurrency.design.c3;

import java.util.concurrent.ArrayBlockingQueue;

/**
 * @Author: xiantang
 * @Date: 2019/9/4 13:54
 */
public class BlockingQueueTest {
    public static void main(String[] args) throws InterruptedException {
        /**
         * BlockingQueue
         *      * ArrayBlockingQueue
         *          基于数组实现 适合做有界队列
         *      * LinkedBlockingQueue
         *          基于链表 内部元素可以动态增加
         */
        ArrayBlockingQueue<String> blockingArray = new ArrayBlockingQueue<>(10);
        for (int i = 0; i < 11; i++) {
            /**
             * lock = new ReentrantLock(fair);
             * notEmpty = lock.newCondition();
             * notFull =  lock.newCondition();
             * // 当线程执行take()操作的时候，让线程等待
             * // 在 notEmpty 上
             * // 如果新的元素入队后就执行一次 notEmpty 的通知
             * public E take() throws InterruptedException {
             *         final ReentrantLock lock = this.lock;
             *         lock.lockInterruptibly();
             *         try {
             *             while (count == 0)
             *                 notEmpty.await();
             *             return dequeue();
             *         } finally {
             *             lock.unlock();
             *         }
             * }
             *
             */
            blockingArray.take();

        }
    }
}
