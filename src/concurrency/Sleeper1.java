package concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Sleeper1 implements Runnable {
    private int n;
    private static int taskCount = 0;
    private final int id = taskCount++;

    public Sleeper1(int n) {
        this.n = n;
    }

    @Override
    public void run() {
        try {
            int res = (int) (Math.random() * 10 + 1);
            TimeUnit.MILLISECONDS.sleep(1000 * res);
            System.out.println("#" + id + " " + res+"s");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        ExecutorService exec = Executors.newCachedThreadPool();
        for (int i = 0; i < 10; i++) {
            exec.execute(new Sleeper1(i));
        }
        exec.shutdown();
    }
}
