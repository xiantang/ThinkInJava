package concurrency;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class AyomicIntegerTest implements Runnable {

    private AtomicInteger i = new AtomicInteger();

    public int getI() {
        return i.get();
    }

    private void evenIncrement() {
        i.addAndGet(2);
    }

    @Override
    public void run() {
        while (true) {
            evenIncrement();
        }
    }

    public static void main(String[] args) {
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("Aborting");
                System.exit(0);
            }
        },5000);
        ExecutorService exec =
                Executors.newCachedThreadPool();
        AyomicIntegerTest ait = new AyomicIntegerTest();
        exec.execute(ait);
        while (true) {
            int val = ait.getI();
            if (val % 2 != 0) {
                System.out.println(val);
                System.exit(0);
            }
        }
    }
}
