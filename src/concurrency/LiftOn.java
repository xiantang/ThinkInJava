package concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class LiftOn implements Runnable {
    private static int taskCount = 0;
    // final 初始化不允许被更改
    private final int id = taskCount++;
    public LiftOn() {
        System.out.println(id+" start");
    }

    @Override
    public void run() {
        for (int i = 0; i <3 ; i++) {
            System.out.println(id + i + "running");

            Thread.yield();
        }
        System.out.println(id+" end");
        return;

    }

    public static void main(String[] args) {
//        for (int i = 0; i <100 ; i++) {
//            new Thread(new LiftOn()).start();
//        }
//        ExecutorService exec =  Executors.newCachedThreadPool();
//        for (int i = 0; i < 5; i++) {
//            exec.execute(new LiftOn());
//        }
//        ExecutorService exec =  Executors.newFixedThreadPool(5);
//        for (int i = 0; i < 5; i++) {
//            exec.execute(new LiftOn());
//        }
                ExecutorService exec =  Executors.newSingleThreadExecutor();
        for (int i = 0; i < 5; i++) {
            exec.execute(new LiftOn());
        }

    }
}
