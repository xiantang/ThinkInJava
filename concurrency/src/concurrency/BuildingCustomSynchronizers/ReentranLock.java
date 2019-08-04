package concurrency.BuildingCustomSynchronizers;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.LockSupport;

/**
 * @Author: xiantang
 * @Date: 2019/4/24 15:22
 */
public class ReentranLock implements Lock, Serializable {
    private final Sync sync = new Sync();
    private class Sync extends AbstractQueuedSynchronizer {
        @Override
        protected boolean tryAcquire(int arg) {
//            if (compareAndSetState(0, 1)) {
//                setExclusiveOwnerThread(Thread.currentThread());
//                return true;
//            }
//            return false;
            int c = getState();
            if (c == 0) {
                if (compareAndSetState(0, 1)) {
                    setExclusiveOwnerThread(Thread.currentThread());
                    return true;
                }

                // 可重入
            } else if (Thread.currentThread() == getExclusiveOwnerThread()) {
                setState(c + 1);
                return true;
            }
            return false;
        }

        @Override
        protected boolean tryRelease(int arg) {
            assert arg == 1;
            if (!isHeldExcluesively()) {
                throw new IllegalArgumentException();
            }
            setExclusiveOwnerThread(null);
            setState(0);
            return true;
        }

        public boolean isLocked() {
            return getState() != 0;
        }

        public boolean isHeldExcluesively() {
            return getExclusiveOwnerThread() == Thread.currentThread();
        }

        public Condition newCondition() {
            return new ConditionObject();
        }



    }


    @Override
    public void lock() {
        sync.acquire(1);
    }

    @Override
    public void lockInterruptibly() throws InterruptedException {
        sync.acquireInterruptibly(1);
    }

    @Override
    public boolean tryLock() {
        return sync.tryAcquire(1);
    }

    @Override
    public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
        return sync.tryAcquireNanos(1,unit.toNanos(time));
    }

    @Override
    public void unlock() {
        sync.release(1);
    }

    @Override
    public Condition newCondition() {
        return sync.newCondition();
    }
}

class Test {
    private List<Thread> runnables = new ArrayList<Thread>();
    private ReentranLock reentranLock = new ReentranLock();
    public void dd() throws InterruptedException {
//        reentranLock.lock();
//        try {
//            System.out.println(1);
//        } finally {
//            reentranLock.unlock();
//        }
        runnables.add(Thread.currentThread());
        LockSupport.park(Thread.currentThread());
        System.out.println(1);
    }
    public void test() throws InterruptedException {

//        reentranLock.lock();

        new Thread(new Runnable(){
            @Override
            public void run() {
                try {
                    dd();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
        new Thread(new Runnable(){
            @Override
            public void run() {
                try {
                    dd();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
        TimeUnit.SECONDS.sleep(1);
        for (Thread r : runnables) {
            LockSupport.unpark(r);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        new Test().test();

    }
}
