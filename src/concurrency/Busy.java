package concurrency;

import java.util.concurrent.TimeUnit;

public class Busy implements Runnable {
    boolean cancel = false;
    @Override
    public void run() {
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        cancel = true;

    }

    public static void main(String[] args) {
        Busy busy = new Busy();
        new Thread(busy).run();
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (busy.cancel) {
                    busy.cancel = false;
                    System.out.println("fsadfsdf");
                }
            }
        }).run();
    }
}
