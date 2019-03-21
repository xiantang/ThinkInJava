package concurrency;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Blocker {
    synchronized void waitingCall(){
        try {
            while (!Thread.interrupted()) {
                wait();
                System.out.println(Thread.currentThread() + " ");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    synchronized void prod() {
        notify();
    }

    synchronized void prodAll() {
        notify();
    }

}

class Task implements Runnable {
    static Blocker blocker = new Blocker();

    @Override
    public void run() {
        // Block 等待被激活
        blocker.waitingCall();
    }


}

class Task2 implements Runnable {
    static Blocker blocker = new Blocker();

    @Override
    public void run() {
        // Block 等待被激活
        blocker.waitingCall();
    }

    public static void main(String[] args) throws Exception {
        ExecutorService exec = Executors.newCachedThreadPool();
        for (int i = 0; i < 5; i++) {
            exec.execute(new Task());
        }
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            boolean prod = true;
            @Override
            public void run() {
                if (prod) {
                    System.out.println("\nnotify");
                    Task.blocker.prod();
                    prod = false;
                } else {
                    System.out.println("\nnotifyAll");
                    Task.blocker.prodAll();
                    prod = true;
                }

            }
        },400,400);
        TimeUnit.SECONDS.sleep(5);
        timer.cancel();
        System.out.println("\n Timer canceled");
        TimeUnit.MILLISECONDS.sleep(500);
        System.out.println("\nshutting down");
        exec.shutdownNow();
    }
}


