package concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class Car{
    private boolean waxOn = false;

    // 已经涂蜡完毕
    public synchronized void waxed() {
        waxOn = true;
        notify();
    }

    // 🚗抛光
    public synchronized void buffed() {
        waxOn = false;
        notify();
    }

    // 如果没有涂蜡一直等待
    public synchronized void waitForWaxing() throws InterruptedException {

        while (!waxOn) {
            wait();

        }
    }

    // 抛光成功一直等待
    public synchronized void waitForBuffing() throws InterruptedException {
        while (waxOn) {
            wait();
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
            while (!Thread.currentThread().isInterrupted()) {

                System.out.println("Wax On！");
                TimeUnit.MILLISECONDS.sleep(200);
                //上蜡
                car.waxed();
                // 等待抛光
                car.waitForBuffing();
            }
        } catch (InterruptedException e) {
            System.out.println("Exiting via interrupt");
        }
        System.out.println("Ending Wax On task");
    }
}

class WaxOff implements Runnable {
    private Car car;

    public WaxOff(Car car) {
        this.car = car;
    }

    @Override
    public void run() {
        try {
            while (!Thread.currentThread().isInterrupted()) {
                // 等待涂蜡

                car.waitForWaxing();
                // 抛光
                System.out.println("Wax Off");
                // 正在抛光
                TimeUnit.MILLISECONDS.sleep(200);
                // 已经抛光
                car.buffed();
            }
        } catch (InterruptedException e) {
            System.out.println("Exiting via interrupt");
        }
        System.out.println("Ending Wax Off task");
    }
}


public class WaxOMatic {
    public static void main(String[] args) throws InterruptedException {
        Car car = new Car();
        ExecutorService exec = Executors.newCachedThreadPool();
        exec.execute(new WaxOff(car));
        exec.execute(new WaxOn(car));
        exec.execute(new WaxOn(car));
        TimeUnit.SECONDS.sleep(5);
        exec.shutdownNow();
    }
}
