package concurrency;

import java.util.concurrent.TimeUnit;

public class ADeamon implements Runnable {
    @Override
    public void run() {
        try {
            System.out.println("Starting ADaemon");
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            System.out.println("EXit");
        } finally {
            System.out.println("This should always run");
        }

    }

    public static void main(String[] args) {
        Thread thread = new Thread(new ADeamon());
        thread.setDaemon(true);
        thread.start();
    }
}
