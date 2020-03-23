package info.xiantang.concurrency.collection;

import info.xiantang.algorithm.collection.base.LinkedList;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class LinkedBlockQueue<Item> {
    private LinkedList<Item> linkedList = new LinkedList<>();
    private int limit;
    private ReentrantLock putLock = new ReentrantLock();
    private ReentrantLock takeLock = new ReentrantLock();
    private Condition notFull = putLock.newCondition();
    private Condition notEmpty = takeLock.newCondition();


    LinkedBlockQueue(int limit) {
        this.limit = limit;
    }

    public Item take() throws InterruptedException {
        final ReentrantLock lock = this.takeLock;
        lock.lock();
        try {
            while (linkedList.size() == 0) {
                notEmpty.await();
            }
            Item item = linkedList.lremove();
            signalNotFull();
            return item;
        }finally {
            lock.unlock();
        }
    }

    private void signalNotFull() {
        final ReentrantLock lock = this.putLock;
        lock.lock();
        try {
            notFull.signal();
        }finally {
            lock.unlock();
        }
    }

    private void signalNotEmpty() {
        final ReentrantLock lock = this.takeLock;
        lock.lock();
        try {
            notEmpty.signal();
        }finally {
            lock.unlock();
        }
    }


    public void put(Item item) throws InterruptedException {
        final ReentrantLock lock = this.putLock;
        lock.lock();
        try {
            while (linkedList.size() >= limit) {
                notFull.await();
            }
            linkedList.rinsert(item);
            signalNotEmpty();
        }finally {
            lock.unlock();
        }

    }


    public int size() {
        return linkedList.size();
    }
}
