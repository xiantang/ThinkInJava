package concurrency;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ExpicitPairManager1  extends PairManager{
    private Lock lock = new ReentrantLock();

    @Override
    public synchronized void increment() {
        lock.lock();
        try {
            p.incrementY();
            p.incrementX();
            store(getPair());
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        PairManager
                pman1 = new ExpicitPairManager1(),
                pman2 = new ExpicitPairManager2();
        CriticalSection.testApproaches(pman1,pman2);
    }
}
 class ExpicitPairManager2  extends PairManager{
    private Lock lock = new ReentrantLock();

    @Override
    public  void increment() {
        lock.lock();
        Pair temp;
        try {
            p.incrementY();
            p.incrementX();
            temp = getPair();
        } finally {
            lock.unlock();
        }
        store(temp);
    }
}