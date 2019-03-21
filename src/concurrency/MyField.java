package concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MyField {
    private int a = 1;
    private int b = 3;
    private long c = 123123134;
    private Lock lock = new ReentrantLock();
    private volatile boolean isCan = true;
    public int getA() {
        return a;
    }

    public long getC() {
        return c;
    }

    public boolean isCan() {
        return isCan;
    }

    public synchronized int sum() {
        lock.lock();

        try {
            a += 1;
            a += 2;
            return a;
        } finally {
            lock.unlock();
        }
    }

    public void setCan(boolean can) {
        isCan = can;
    }
}

class MyThread implements Runnable {
    private MyField myField;

    public MyThread(MyField myField) {
        this.myField = myField;
    }

    @Override
    public void run() {
        while (myField.isCan()) {
            int res = myField.sum();
//            System.out.println(1);
            if (res % 3 != 1) {
                myField.setCan(false);
                System.out.println("dasdasdasdad");
            }
        }
    }

    public static void main(String[] args) {
        MyField field = new MyField();
        ExecutorService exec = Executors.newCachedThreadPool();
        for (int i = 0; i < 10; i++) {
            exec.execute(new Runnable() {
                @Override
                public void run() {
                    while (true){
                        System.out.println(field.getC());
                    }


                }
            });
        }
        exec.shutdown();
    }
}

