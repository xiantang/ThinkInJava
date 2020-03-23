package info.xiantang.concurrency.design.c2;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * @Author: xiantang
 * @Date: 2019/9/3 16:43
 */
public class Semap implements Runnable {
    final Semaphore semp = new Semaphore(5);

    @Override
    public void run() {
        try {
            semp.acquire();
            System.out.println(Thread.currentThread().getId() + ":done!");
            semp.release();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        ExecutorService exec = Executors.newFixedThreadPool(20);
        final Semap demo = new Semap();
        for (int i = 0; i < 20; i++) {
            exec.submit(demo);
        }
        exec.shutdown();

    }
}
