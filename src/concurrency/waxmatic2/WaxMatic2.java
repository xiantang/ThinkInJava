package concurrency.waxmatic2;


import java.util.concurrent.*;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Car {
    private Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();
    private boolean WaxOn = false;

    public void waxed() {
//        ClassLoader
        lock.lock();
        try {
            WaxOn = true;
            condition.signalAll();
        }finally {
            lock.unlock();
        }
    }

    public void buffed() {
        lock.lock();
        try {
            WaxOn = false;
            condition.signalAll();
        }finally {
            lock.unlock();
        }
    }
    public void waitForWaxing() throws InterruptedException {
        lock.lock();
        try {
           while (WaxOn == false)
               condition.await();
        }finally {
            lock.unlock();
        }
    }
    public void waitForBuffing() throws InterruptedException {
        lock.lock();
        try {
            while (WaxOn == true)
                condition.await();
        }finally {
            lock.unlock();
        }
    }

}

class WaxOn implements Runnable {
    private Car car;

    public WaxOn(Car car) {
        this.car = car;
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {

                System.out.println("Wax On");
                TimeUnit.MILLISECONDS.sleep(200);
                car.waxed();
                car.waitForBuffing();
            }
        } catch (InterruptedException e) {
            System.out.println("InterruptedException");
        }
        System.out.println("End Wax");
    }
}

class WaxOff implements Runnable {
    private Car car;

    public WaxOff(Car car) {
        this.car = car;
    }

    @Override
    public void run() {
        System.out.println(111);
//        try {
//            while (!Thread.interrupted()) {
//                car.waitForWaxing();
//                System.out.println("Wax Off");
//                TimeUnit.MILLISECONDS.sleep(200);
//                car.buffed();
//            }
//        } catch (InterruptedException e) {
//            System.out.println("InterruptedException");
//        }
//        System.out.println("End WaxOn");
    }
}


public class WaxMatic2 {
    public static void main(String[] args) throws InterruptedException {
        Car car = new Car();
//        ThreadPoolExecutor exec = Executors.newCachedThreadPool();
//        exec.setRejectedExecutionHandler();
//        new Thread().run();
        new Thread(new WaxOff(car)).run();
//        exec.execute(new WaxOn(car));
//        TimeUnit.SECONDS.sleep(5);
//        exec.shutdownNow();
    }
}
