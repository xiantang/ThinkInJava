package concurrency;

import java.util.concurrent.TimeUnit;

public class SimpleThread extends Thread {
    private int countDown = 5;
    private static int threadCount = 0;
    public SimpleThread() {
        // Store the thread name:
        super(Integer.toString(++threadCount));

    }
    public String toString() {
        return "#" + getName() + "(" + countDown + "), ";
    }
    public void run() {
        while(true) {
            System.out.print(this);
            if(--countDown == 0)
                return;
        }
    }
    public static void main(String[] args) throws InterruptedException {
        for(int i = 0; i < 5; i++){
            Thread t = new SimpleThread();

            t.setDaemon(true);
            t. start();
        }
//        TimeUnit.SECONDS.sleep(1);

    }
}
