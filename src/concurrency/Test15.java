package concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Test15 {
    private Object sysncObject = new Object();
    private Lock lock = new ReentrantLock();
    public void g() {
//        synchronized (sysncObject) {
//            for (int i = 0; i < 5; i++) {
//                System.out.println(Thread.currentThread().toString()+" g()");
//                Thread.yield();
//            }
//        }
        lock.lock();
        try{
            for (int i = 0; i < 5; i++) {
                System.out.println(Thread.currentThread().toString()+" g() " + sysncObject);
                Thread.yield();
            }
        }finally {
            lock.unlock();
        }

    }
    public void f() {
//        synchronized (sysncObject) {
//            for (int i = 0; i < 5; i++) {
//                System.out.println(Thread.currentThread().toString()+" f()");
//                Thread.yield();
//            }
//        }
        lock.lock();
        try{
            for (int i = 0; i < 5; i++) {
                System.out.println(Thread.currentThread().toString()+" f() " + sysncObject);
                Thread.yield();
            }


        }finally {
            lock.unlock();
        }
    }
    public synchronized void z() {
//        synchronized (this) {
//            for (int i = 0; i < 5; i++) {
//                System.out.println(Thread.currentThread().toString()+" z()");
//                Thread.yield();
//            }
//        }
        lock.lock();
        Object temp = null;
        try{
            for (int i = 0; i < 5; i++) {
                System.out.println(Thread.currentThread().toString()+" z() " + sysncObject);
                temp = sysncObject;
                Thread.yield();
            }
        }finally {
            lock.unlock();
        }
        sysncObject = temp;
    }
    public void d() {
//        synchronized (sysncObject) {
//            for (int i = 0; i < 5; i++) {
//                System.out.println(Thread.currentThread().toString()+" d()");
//                Thread.yield();
//            }
//        }
        lock.lock();
        try{
            for (int i = 0; i < 5; i++) {
                System.out.println(Thread.currentThread().toString()+" d() " + sysncObject);
                Thread.yield();
            }


        }finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        ExecutorService exec = Executors.newCachedThreadPool();
        Test15 ds = new Test15();
        exec.execute(new Thread() {
            public void run() {
                ds.f();
            }
        });
        exec.execute(new Thread() {
            public void run() {
                ds.z();
            }
        });
        exec.execute(new Thread() {
            public void run() {
                ds.d();
            }
        });
        exec.execute(new Thread() {
            public void run() {
                ds.g();
            }
        });

        exec.shutdown();
    }
}
