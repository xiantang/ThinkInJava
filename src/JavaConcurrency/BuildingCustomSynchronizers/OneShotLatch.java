package JavaConcurrency.BuildingCustomSynchronizers;

import java.util.concurrent.locks.AbstractQueuedSynchronizer;

/**
 * @Author: xiantang
 * @Date: 2019/4/24 14:13
 */
public class OneShotLatch {
    private final Sync sync = new Sync();


    // 释放操作
    public void signal() {
        sync.releaseShared(0);
        // releaseShared() -> tryReleaseShared()

    }

    // 获取操作
    public void await() throws InterruptedException {
        // 处理失败的方式是将线程放入等待线程队列中
        sync.acquireSharedInterruptibly(0);
    }


    private class Sync extends AbstractQueuedSynchronizer {
        protected int tryAcquireShared(int ignore) {
            // 如果闭锁式开的这个操作将成功，否则失败
            return (getState() == 1) ? 1 : -1;
        }

        protected boolean tryReleaseShared(int ignored) {
            setState(1);// 现在打开闭锁
            return true;// 现在其他线程可以获取该闭锁
        }

    }

    public static void main(String[] args) {
        final OneShotLatch oneShotLatch = new OneShotLatch();
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    oneShotLatch.await();
                    System.out.println(111);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
        oneShotLatch.signal();
    }

}
